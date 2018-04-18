package com.freight.ms.model;

import java.util.Date;

public class Role {
    /**
     * 角色id
     * 表 : role
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 角色名，用于前端展示
     * 表 : role
     * 对应字段 : name
     */
    private String name;

    /**
     * 说明
     * 表 : role
     * 对应字段 : description
     */
    private String description;

    /**
     * 标识符，用于后端权限判断
     * 表 : role
     * 对应字段 : identifier
     */
    private String identifier;

    /**
     * 创建时间
     * 表 : role
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : role
     * 对应字段 : update_time
     */
    private Date updateTime;

    /**
     *
     */
    public Role(Integer id, String name, String description, String identifier, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.identifier = identifier;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Role() {
        super();
    }

    /**
     * get method 
     *
     * @return role.id：角色id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  角色id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return role.name：角色名，用于前端展示
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  角色名，用于前端展示
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return role.description：说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * set method 
     *
     * @param description  说明
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * get method 
     *
     * @return role.identifier：标识符，用于后端权限判断
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * set method 
     *
     * @param identifier  标识符，用于后端权限判断
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    /**
     * get method 
     *
     * @return role.create_time：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * set method 
     *
     * @param createTime  创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * get method 
     *
     * @return role.update_time：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * set method 
     *
     * @param updateTime  更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}