package com.freight.ms.service;

import com.freight.ms.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wyq on 2018/4/2.
 */

public interface UserService {

    User findUserByUsername(String username);

    User findUserById(Integer id);

    String getRoleID(String username);

    Set<String> getOperationID(String username);

    String findUsers(Map<String, Object> paramMap);

    void addUser(User user);

    void editUser(User user);

    void deleteUsers(List<Integer> list);

    void changeStatus(List<Integer> list);

    void setRole(int userId, int roleId);
}
