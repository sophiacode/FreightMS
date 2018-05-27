package com.freight.ms.controller;

import com.freight.ms.common.constant.SessionConstant;
import com.freight.ms.common.constant.URLConstant;
import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.User;
import com.freight.ms.service.UserService;
import com.freight.ms.system.log.BusinessLog;
import com.freight.ms.util.JsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
            return "redirect:" + URLConstant.URL_MANAGE;
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    @BusinessLog(operation = "用户登录")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "isRemember") Boolean isRemember,
                        HttpSession session) {
        try{
            Subject currentUser = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(isRemember);

            currentUser.login(token);

            User user = userService.findUserByUsername(username);
            session.setAttribute(SessionConstant.CURRENT_USER, user);

            return SuccessJson.getJson("登录成功", URLConstant.URL_MANAGE);
        }catch (UnknownAccountException | IncorrectCredentialsException e1){
            throw new BusinessException(BusinessEnumException.LOGIN_ERROR);
        }catch (LockedAccountException e2){
            throw new BusinessException(BusinessEnumException.LOGIN_USER_FREEZE);
        } catch (Exception e3){
            throw new BusinessException(BusinessEnumException.LOGIN_UNKNOWN);
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();

        return "redirect:" + URLConstant.URL_PREFIX;
    }
}
