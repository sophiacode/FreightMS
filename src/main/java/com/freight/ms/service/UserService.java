package com.freight.ms.service;

import com.freight.ms.model.User;

import java.util.Map;

/**
 * Created by wyq on 2018/4/2.
 */

public interface UserService {

    User findUserByUsername(String username);

    String findUsers(Map<String, Object> paramMap);

    String addUser(User user);


}
