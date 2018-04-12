package com.freight.ms.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.freight.ms.dao.UserMapper;
import com.freight.ms.model.User;
import com.freight.ms.service.UserService;
import com.freight.ms.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wyq on 2018/4/2.
 */

@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public User findUserByUsername(String username){
        return userMapper.selectByUsername(username);
    }

    public String findUsers(Map<String, Object> paramMap){
        JSONObject object = new JSONObject();
        object.put("total",userMapper.getCount());
        object.put("rows",userMapper.selectByParams(paramMap));

        return object.toJSONString();
    }

    public String addUser(User user){
        user = new PasswordUtil().encryptPassword(user);

        JSONObject json = new JSONObject();
        json.put("msg", "test");

        try{
            userMapper.insert(user);
        }catch (Exception e){
            json.put("msg", "exception");
        }

        return json.toJSONString();
    }

}
