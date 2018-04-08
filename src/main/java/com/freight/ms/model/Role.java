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
     * 角色名
     * 表 : role
     * 对应字段 : name
     */
    private String name;

    /**
     * 说明
     * 表 : role
     * 对应字段 : comment
     */
    private String comment;

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
    public Role(Integer id, String name, String comment, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.comment = comment;
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
     * @return role.name：角色名
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  角色名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return role.comment：说明
     */
    public String getComment() {
        return comment;
    }

    /**
     * set method 
     *
     * @param comment  说明
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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