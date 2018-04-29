package com.freight.ms.serviceImpl;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.OperationMapper;
import com.freight.ms.dao.PermissionMapper;
import com.freight.ms.model.Operation;
import com.freight.ms.model.Permission;
import com.freight.ms.model.Role;
import com.freight.ms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wyq on 2018/4/12.
 */

@Service("OperationService")
public class OperationServiceImpl implements OperationService{
    @Autowired
    OperationMapper operationMapper;

    @Autowired
    PermissionMapper permissionMapper;

    public List<Operation> getAll() {
        return operationMapper.selectAll();
    }

    public List<Operation> getOperationsOfRole(Role role){
        List<Operation> operations = operationMapper.selectByRoleId(role.getId());

        for(int i = 0; i<operations.size(); i++){
            List<Operation> children = operationMapper.findChildren(operations.get(i).getId());
            operations.addAll(children);
        }

        return operations;
    }

    public void updatePermissions(Integer roleId, List<Integer> operations){
        try {
            permissionMapper.deleteByRoleId(roleId);

            for (Integer id : operations) {
                Operation o = operationMapper.selectByPrimaryKey(id);
                if (o.getType() == 2) {
                    Permission permission = new Permission(null, roleId, id);
                    permissionMapper.insert(permission);
                }
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.ROLE_PERMISSION_FAIL);
        }
    }
}
