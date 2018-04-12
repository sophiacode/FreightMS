package com.freight.ms.controller;

import com.freight.ms.common.constant.SessionConstant;
import com.freight.ms.common.constant.URLConstant;
import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.model.User;
import com.freight.ms.service.UserService;
import com.freight.ms.util.JsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by sophia on 2018/3/23.
 */

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    private JsonUtil jsonUtil = new JsonUtil();

    @RequestMapping("/")
    public String loginView(HttpSession session){
        if( session.getAttribute(SessionConstant.CURRENT_USER) == null ){
            return "/sign-in.html";
        } else{
            return URLConstant.REDIRECT + URLConstant.URL_NOTIFACTION;
        }
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "isRemember") Boolean isRemember,
                        HttpSession session) {
        try{
            Factory<SecurityManager> factory =
                    new IniSecurityManagerFactory("classpath:shiro.ini");

            SecurityManager securityManager = factory.getInstance();
            SecurityUtils.setSecurityManager(securityManager);

            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(isRemember);

            currentUser.login(token);

            User user = userService.findUserByUsername(username);
            session.setAttribute(SessionConstant.CURRENT_USER, user);

            return URLConstant.REDIRECT + URLConstant.URL_NOTIFACTION;
        }catch (AuthenticationException e){
            if(e.getClass() == UnknownAccountException.class || e.getClass() == IncorrectCredentialsException.class){
                throw new BusinessException(BusinessEnumException.LOGIN_ERROR);
            }else if(e.getClass() == LockedAccountException.class){
                throw new BusinessException(BusinessEnumException.LOGIN_USER_FREEZE);
            }else{
                throw new BusinessException(BusinessEnumException.LOGIN_UNKNOWN);
            }
        }catch (Exception e2){
            throw new BusinessException(BusinessEnumException.UNKNOWN_ERROR);
        }
    }
}
