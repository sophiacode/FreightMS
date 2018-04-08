package com.freight.ms.model;

import java.util.Date;

public class Log {
    /**
     * 日志id
     * 表 : log
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 日志名称
     * 表 : log
     * 对应字段 : name
     */
    private String name;

    /**
     * 产生日志的用户id
     * 表 : log
     * 对应字段 : user_id
     */
    private Integer userId;

    /**
     * 操作状态（1：成功，2：失败）
     * 表 : log
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 消息
     * 表 : log
     * 对应字段 : message
     */
    private String message;

    /**
     * 创建时间
     * 表 : log
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     *
     */
    public Log(Integer id, String name, Integer userId, Integer status, String message, Date createTime) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.status = status;
        this.message = message;
        this.createTime = createTime;
    }

    /**
     *
     */
    public Log() {
        super();
    }

    /**
     * get method 
     *
     * @return log.id：日志id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  日志id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return log.name：日志名称
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  日志名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return log.user_id：产生日志的用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * set method 
     *
     * @param userId  产生日志的用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * get method 
     *
     * @return log.status：操作状态（1：成功，2：失败）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  操作状态（1：成功，2：失败）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return log.message：消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * set method 
     *
     * @param message  消息
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * get method 
     *
     * @return log.create_time：创建时间
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
}