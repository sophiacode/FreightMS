package com.freight.ms.model;

import java.util.Date;

public class Consignor {
    /**
     * 货主用户id
     * 表 : consignor
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 电话号码
     * 表 : consignor
     * 对应字段 : telephone
     */
    private String telephone;

    /**
     * 密码
     * 表 : consignor
     * 对应字段 : password
     */
    private String password;

    /**
     * 加密盐
     * 表 : consignor
     * 对应字段 : salt
     */
    private String salt;

    /**
     * 头像
     * 表 : consignor
     * 对应字段 : profile_picture
     */
    private String profilePicture;

    /**
     * 积分
     * 表 : consignor
     * 对应字段 : point
     */
    private Integer point;

    /**
     * 
     * 表 : consignor
     * 对应字段 : evaluate_grade
     */
    private Float evaluateGrade;

    /**
     * 账号状态（1：正常，2：冻结）
     * 表 : consignor
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 创建时间
     * 表 : consignor
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : consignor
     * 对应字段 : update_time
     */
    private Date updateTime;

    /**
     *
     */
    public Consignor(Integer id, String telephone, String password, String salt, String profilePicture, Integer point, Float evaluateGrade, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.telephone = telephone;
        this.password = password;
        this.salt = salt;
        this.profilePicture = profilePicture;
        this.point = point;
        this.evaluateGrade = evaluateGrade;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Consignor() {
        super();
    }

    /**
     * get method 
     *
     * @return consignor.id：货主用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  货主用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return consignor.telephone：电话号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * set method 
     *
     * @param telephone  电话号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * get method 
     *
     * @return consignor.password：密码
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
     * @return consignor.salt：加密盐
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
     * @return consignor.profile_picture：头像
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * set method 
     *
     * @param profilePicture  头像
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture == null ? null : profilePicture.trim();
    }

    /**
     * get method 
     *
     * @return consignor.point：积分
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * set method 
     *
     * @param point  积分
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * get method 
     *
     * @return consignor.evaluate_grade：
     */
    public Float getEvaluateGrade() {
        return evaluateGrade;
    }

    /**
     * set method 
     *
     * @param evaluateGrade  
     */
    public void setEvaluateGrade(Float evaluateGrade) {
        this.evaluateGrade = evaluateGrade;
    }

    /**
     * get method 
     *
     * @return consignor.status：账号状态（1：正常，2：冻结）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  账号状态（1：正常，2：冻结）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return consignor.create_time：创建时间
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
     * @return consignor.update_time：更新时间
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