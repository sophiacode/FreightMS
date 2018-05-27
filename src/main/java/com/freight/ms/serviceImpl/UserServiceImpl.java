package com.freight.ms.serviceImpl;

import com.freight.ms.common.constant.UserEnum;
import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.RoleMapper;
import com.freight.ms.dao.UserMapper;
import com.freight.ms.model.Operation;
import com.freight.ms.model.Role;
import com.freight.ms.model.User;
import com.freight.ms.service.OperationService;
import com.freight.ms.service.UserService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.util.PasswordUtil;
import com.freight.ms.wrapper.UserManageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by wyq on 2018/4/2.
 */

@Service("UserService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Resource
    private OperationService operationService;

    public User findUserByUsername(String username){
        return userMapper.selectByUsername(username);
    }

    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public String getRoleID(String username){
        try{
            User user = userMapper.selectByUsername(username);
            Role role = roleMapper.selectByPrimaryKey(user.getRoleId());
            return role.getIdentifier();
        }catch (Exception e){
            return null;
        }
    }

    public Set<String> getOperationID(String username) {
        try{
            User user = userMapper.selectByUsername(username);
            Role role = roleMapper.selectByPrimaryKey(user.getRoleId());

            List<Operation> operations = operationService.getOperationsOfRole(role);
            Set<String> operationIDSet = new HashSet<>();
            for(Operation o:operations){
                operationIDSet.add(o.getIdentifier());
            }

            return operationIDSet;
        }catch (Exception e){
            return null;
        }
    }

    public String findUsers(Map<String, Object> paramMap){
        List<User> userList = userMapper.selectByParams(paramMap);
        for(User user:userList){
            if(user.getRoleId() != null){
                Role role = roleMapper.selectByPrimaryKey(user.getRoleId());
                user.setRoleName(role.getName());
            }
        }

        return JsonUtil.getTableListJson(userMapper.getCount(),
                new UserManageWrapper(userList).wrap());
    }

    public void addUser(User user){
        if(findUserByUsername(user.getUsername()) != null){
            throw new BusinessException(BusinessEnumException.USER_ADD_REPEAT);
        }

        user = new PasswordUtil().encryptPassword(user);
        try{
            userMapper.insertSelective(user);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_ADD_FAIL);
        }
    }

    public void editUser(User user){
        if(findUserById(user.getId()) == null){
            throw new BusinessException(BusinessEnumException.USER_NOT_FOUND);
        }

        if(user.getPassword() != null){
            user = new PasswordUtil().encryptPassword(user);
        }

        try{
            userMapper.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_EDIT_FAIL);
        }
    }

    public void deleteUsers(List<Integer> list){
        try{
            for(Integer id:list){
                userMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_DELETE_FAIL);
        }
    }

    public void changeStatus(List<Integer> list){
        List<User> users = new ArrayList<>();

        for(Integer id:list){
            User user = userMapper.selectByPrimaryKey(id);

            if(user.getType() == UserEnum.USER_TYPE_ADMIN.getCode()){
                throw new BusinessException(BusinessEnumException.USER_FREEZE_ADMIN_ERROR);
            }

            if(user.getStatus() == UserEnum.USER_STATUS_OK.getCode()){
                user.setStatus(UserEnum.USER_STATUS_FREEZE.getCode());
            }else{
                user.setStatus(UserEnum.USER_STATUS_OK.getCode());
            }
            users.add(user);
        }

        try{
            for(User user:users){
                userMapper.updateByPrimaryKeySelective(user);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_CHANGE_STATUS_FAIL);
        }
    }

    public void setRole(int userId, int roleId){
        try{
            User user = userMapper.selectByPrimaryKey(userId);
            user.setRoleId(roleId);
            userMapper.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_SET_ROLE_ERROR);
        }
    }

    public void changePassword(Integer id, String oldPassword, String newPassword){
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);

        }
    }
}
