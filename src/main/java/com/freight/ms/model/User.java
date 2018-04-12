package com.freight.ms.model;

import java.util.Date;

public class User {
    /**
     * 用户id
     * 表 : user
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 用户名
     * 表 : user
     * 对应字段 : username
     */
    private String username;

    /**
     * 密码
     * 表 : user
     * 对应字段 : password
     */
    private String password;

    /**
     * 加密盐
     * 表 : user
     * 对应字段 : salt
     */
    private String salt;

    /**
     * 姓名
     * 表 : user
     * 对应字段 : name
     */
    private String name;

    /**
     * 性别（1：男，2：女）
     * 表 : user
     * 对应字段 : sex
     */
    private Integer sex;

    /**
     * 年龄
     * 表 : user
     * 对应字段 : age
     */
    private Integer age;

    /**
     * 手机号
     * 表 : user
     * 对应字段 : telephone
     */
    private String telephone;

    /**
     * 状态（0：正常，1：冻结）
     * 表 : user
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 用户类型（0：普通用户，1：超级管理员）
     * 表 : user
     * 对应字段 : type
     */
    private Integer type;

    /**
     * 角色id
     * 表 : user
     * 对应字段 : role_id
     */
    private Integer roleId;

    /**
     * 创建时间
     * 表 : user
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : user
     * 对应字段 : update_time
     */
    private Date updateTime;

    /**
     *
     */
    public User(Integer id, String username, String password, String salt, String name, Integer sex, Integer age, String telephone, Integer status, Integer type, Integer roleId, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.status = status;
        this.type = type;
        this.roleId = roleId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public User() {
        super();
    }

    /**
     * get method 
     *
     * @return user.id：用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return user.username：用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * set method 
     *
     * @param username  用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * get method 
     *
     * @return user.password：密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * set method 
     *
     * @param password  密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * get method 
     *
     * @return user.salt：加密盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * set method 
     *
     * @param salt  加密盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * get method 
     *
     * @return user.name：姓名
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return user.sex：性别（1：男，2：女）
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * set method 
     *
     * @param sex  性别（1：男，2：女）
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * get method 
     *
     * @return user.age：年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * set method 
     *
     * @param age  年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * get method 
     *
     * @return user.telephone：手机号
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * set method 
     *
     * @param telephone  手机号
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * get method 
     *
     * @return user.status：状态（0：正常，1：冻结）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  状态（0：正常，1：冻结）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return user.type：用户类型（0：普通用户，1：超级管理员）
     */
    public Integer getType() {
        return type;
    }

    /**
     * set method 
     *
     * @param type  用户类型（0：普通用户，1：超级管理员）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * get method 
     *
     * @return user.role_id：角色id
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
     * @return user.create_time：创建时间
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
     * @return user.update_time：更新时间
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

    public String getCredentialsSalt(){
        return username + salt;
    }
}