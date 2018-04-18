package com.freight.ms.model;

public class Operation {
    /**
     * 操作id
     * 表 : operation
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 操作名称，用于前端显示
     * 表 : operation
     * 对应字段 : name
     */
    private String name;

    /**
     * 操作标识符，用于后端权限判断
     * 表 : operation
     * 对应字段 : identifier
     */
    private String identifier;

    /**
     * 操作类型（1：菜单，2：按钮）
     * 表 : operation
     * 对应字段 : type
     */
    private Integer type;

    /**
     * 父编号
     * 表 : operation
     * 对应字段 : parent_id
     */
    private Integer parentId;

    /**
     *
     */
    public Operation(Integer id, String name, String identifier, Integer type, Integer parentId) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.type = type;
        this.parentId = parentId;
    }

    /**
     *
     */
    public Operation() {
        super();
    }

    /**
     * get method 
     *
     * @return operation.id：操作id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  操作id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return operation.name：操作名称，用于前端显示
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  操作名称，用于前端显示
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return operation.identifier：操作标识符，用于后端权限判断
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * set method 
     *
     * @param identifier  操作标识符，用于后端权限判断
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    /**
     * get method 
     *
     * @return operation.type：操作类型（1：菜单，2：按钮）
     */
    public Integer getType() {
        return type;
    }

    /**
     * set method 
     *
     * @param type  操作类型（1：菜单，2：按钮）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * get method
     *
     * @return operation.parent_id：父编号
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * set method
     *
     * @param parentId  父编号
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}