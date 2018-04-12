package com.freight.ms.controller;

import com.freight.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyq on 2018/4/2.
 */

@Controller
@RequestMapping("/user_manage")
public class UserManageController {
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String index(){
        return "/user/user.html";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
     public String getList(@RequestParam(value = "username",required = false) String username,
                          @RequestParam(value = "name",required = false) String name,
                          @RequestParam(value = "sex",required = false) String sex,
                          @RequestParam(value = "age",required = false) String age,
                          @RequestParam(value = "telephone",required = false) String telephone,
                          @RequestParam(value = "status",required = false) String status,
                          @RequestParam(value = "type",required = false) String type,
                          @RequestParam(value = "createStartTime",required = false) String createStartTime,
                          @RequestParam(value = "createEndTime",required = false) String createEndTime,
                          @RequestParam(value = "limit",required = false) Integer limit,
                          @RequestParam(value = "offset",required = false) Integer offset){
        System.out.print("username:"+username+"\n");

        if(limit == null){
            limit = 10;
        }
        if(offset == null){
            offset = 0;
        }

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username",username);
        paramMap.put("name",name);
        paramMap.put("sex",sex);
        paramMap.put("age",age);
        paramMap.put("telephone", telephone);
        paramMap.put("status", status);
        paramMap.put("type", type);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return userService.findUsers(paramMap);
    }
}
