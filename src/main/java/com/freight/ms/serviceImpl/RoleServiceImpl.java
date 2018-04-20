package com.freight.ms.serviceImpl;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.RoleMapper;
import com.freight.ms.model.Role;
import com.freight.ms.service.RoleService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.RoleManageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    public Role findRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public String findRoles(Map<String, Object> paramMap){
        List<Role> roleList = roleMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(roleMapper.getCount(),
                new RoleManageWrapper(roleList).wrap());
    }

    public void addRole(Role role, List<Integer> permissions){
        try{
            roleMapper.insertSelective(role);
            //TODO:permission
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_ADD_FAIL);    //TODO:异常
        }
    }

    public void editRole(Role role, List<Integer> permissions){
        try{
            roleMapper.updateByPrimaryKeySelective(role);
            //TODO:permission
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_EDIT_FAIL);   //TODO:异常
        }
    }

    public void deleteRoles(List<Integer> list){
        try{
            for(Integer id:list){
                roleMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_DELETE_FAIL);  //TODO:异常
        }
    }

    public List<Role> getAllRole() {
        return roleMapper.selectAll();
    }
}
