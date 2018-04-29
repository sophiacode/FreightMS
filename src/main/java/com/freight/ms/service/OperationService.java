package com.freight.ms.service;

import com.freight.ms.model.Operation;
import com.freight.ms.model.Role;

import java.util.List;

/**
 * Created by wyq on 2018/4/12.
 */
public interface OperationService {
    List<Operation> getAll();

    List<Operation> getOperationsOfRole(Role role);

    void updatePermissions(Integer roleId, List<Integer> operations);
}
