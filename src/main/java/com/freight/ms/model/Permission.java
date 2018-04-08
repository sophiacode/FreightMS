package com.freight.ms.model;

public class Permission {
    /**
     * 权限id
     * 表 : permission
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 角色id
     * 表 : permission
     * 对应字段 : role_id
     */
    private Integer roleId;

    /**
     * 操作id
     * 表 : permission
     * 对应字段 : operation_id
     */
    private Integer operationId;

    /**
     *
     */
    public Permission(Integer id, Integer roleId, Integer operationId) {
        this.id = id;
        this.roleId = roleId;
        this.operationId = operationId;
    }

    /**
     *
     */
    public Permission() {
        super();
    }

    /**
     * get method 
     *
     * @return permission.id：权限id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  权限id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return permission.role_id：角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * set method 
     *
     * @param roleId  角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * get method 
     *
     * @return permission.operation_id：操作id
     */
    public Integer getOperationId() {
        return operationId;
    }

    /**
     * set method 
     *
     * @param operationId  操作id
     */
    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }
}