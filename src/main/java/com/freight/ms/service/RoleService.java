package com.freight.ms.service;

import com.freight.ms.model.Role;
import com.freight.ms.model.User;

import java.util.List;

/**
 * Created by wyq on 2018/4/12.
 */
public interface RoleService {
    Role getRoleOfUser(User user);

    List<Role> getAllRole();
}
