package com.freight.ms.system.log;

import com.freight.ms.common.constant.LogEnum;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.model.Log;
import com.freight.ms.service.LogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Configurable
public class LogAspect {
    @Autowired
    private LogService logService;

    @Pointcut(value = "@annotation(com.freight.ms.system.log.BusinessLog)")
    public void cutService(){}

    @After("cutService()")
    public void writeBusinessLog(JoinPoint point){
        try{
            Signature signature = point.getSignature();
            if(!(signature instanceof MethodSignature)){
                return;
            }
            MethodSignature methodSignature = (MethodSignature)signature;
            Object target = point.getTarget();
            Method method = target.getClass().getMethod(methodSignature.getName(),
                    methodSignature.getParameterTypes());
            String methodName = method.getName();
            String className = point.getTarget().getClass().getName();
            Object[] params = point.getArgs();
            String message = className + ":" + methodName;

            BusinessLog annotation = method.getAnnotation(BusinessLog.class);
            String operation = annotation.operation();

            String username;

            String type;
            if(operation.equals("用户登录")) {
                type="登录日志";
                username = (String)point.getArgs()[0];
            }else{
                type="业务日志";
                username = SecurityUtils.getSubject().getPrincipal().toString();
            }

            Log log = new Log(null, type, operation, username, LogEnum.LOG_STATUS_SUCCESS.getCode(), message, null);
            logService.addLog(log);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterThrowing(pointcut = "cutService()", throwing="exception")
    public void writeExceptionLog(JoinPoint point, Throwable exception){
        try{
            Signature signature = point.getSignature();
            if(!(signature instanceof MethodSignature)){
                return;
            }
            MethodSignature methodSignature = (MethodSignature)signature;
            Object target = point.getTarget();
            Method method = target.getClass().getMethod(methodSignature.getName(),
                    methodSignature.getParameterTypes());
            BusinessLog annotation = method.getAnnotation(BusinessLog.class);
            String operation = annotation.operation();

            String message;
            if(exception instanceof BusinessException){
                message = ((BusinessException)exception).getMsg();
            }else{
                message = exception.getMessage();
            }

            String username;
            String type;
            if(operation.equals("用户登录")) {
                type="登录日志";
                username = (String)point.getArgs()[0];
            }else{
                type="异常日志";
                username = SecurityUtils.getSubject().getPrincipal().toString();
            }

            Log log = new Log(null, type, operation, username, LogEnum.LOG_STATUS_FAIL.getCode(), message, null);
            logService.addLog(log);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
