package com.freight.ms.serviceImpl;

import com.freight.ms.dao.OperationMapper;
import com.freight.ms.model.Operation;
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

    public List<Operation> getOperationsOfRole(Role role){
        List<Operation> operations = operationMapper.selectByRoleId(role.getId());

        for(int i = 0; i<operations.size(); i++){
            List<Operation> children = operationMapper.findChildren(operations.get(i).getId());
            operations.addAll(children);
        }

        return operations;
    }
}
