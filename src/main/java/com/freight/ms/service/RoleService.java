package com.freight.ms.service;

import com.freight.ms.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    Role findRoleById(Integer id);

    String findRoles(Map<String, Object> paramMap);

    void addRole(Role role, List<Integer> permissions);

    void editRole(Role role, List<Integer> permissions);

    void deleteRoles(List<Integer> list);

    List<Role> getAllRole();

}
