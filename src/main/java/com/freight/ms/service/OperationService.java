package com.freight.ms.service;

import com.freight.ms.model.Operation;
import com.freight.ms.model.Role;

import java.util.List;

public interface OperationService {
    List<Operation> getAll();

    List<Operation> getOperationsOfRole(Role role);

    void updatePermissions(Integer roleId, List<Integer> operations);
}
