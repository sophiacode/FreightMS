package com.freight.ms.serviceImpl;

import com.freight.ms.dao.RoleMapper;
import com.freight.ms.model.Role;
import com.freight.ms.model.User;
import com.freight.ms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wyq on 2018/4/12.
 */

@Service("RoleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleMapper roleMapper;

    public Role getRoleOfUser(User user){
        if(user.getRoleId() == null){
            return null;
        }
        return roleMapper.selectByPrimaryKey(user.getRoleId());
    }

    public List<Role> getAllRole(){
        return roleMapper.selectAll();
    }
}
