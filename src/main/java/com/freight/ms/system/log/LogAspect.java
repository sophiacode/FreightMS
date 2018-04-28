package com.freight.ms.system.log;

import com.freight.ms.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 * Created by wyq on 2018/4/16.
 */

@Aspect
@Component
@Configurable
public class LogAspect {
    @Autowired
    private LogService logService;

    @Pointcut(value = "@annotation(com.freight.ms.system.log.BusinessLog)")
    public void cutService(){}

    @Around("cutService()")
    public Object writeBusinessLog(ProceedingJoinPoint point) throws Throwable{
        Object result = point.proceed();

        /*try{
            String username = SecurityUtils.getSubject().getPrincipal().toString();

            Signature signature = point.getSignature();
            if(!(signature instanceof MethodSignature)){
                throw new IllegalArgumentException("该注解只能用于方法");
            }

            MethodSignature methodSignature = (MethodSignature)signature;
            Object target = point.getTarget();
            Method method = target.getClass().getMethod(methodSignature.getName(),
                    methodSignature.getParameterTypes());
            String methodName = method.getName();
            String className = point.getTarget().getClass().getName();
            //Object[] params = point.getArgs();
            String message = className + ":" + methodName;

            BusinessLog annotation = method.getAnnotation(BusinessLog.class);
            String operation = annotation.operation();
            Log log = new Log(null, "业务日志", operation, username, LogEnum.LOG_STATUS_SUCCESS.getCode(), message, null);
            logService.addLog(log);
        }catch (Exception e){
            e.printStackTrace();
        }*/

        return result;
    }
}
