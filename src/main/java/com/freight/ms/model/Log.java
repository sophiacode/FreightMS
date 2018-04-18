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
     * 日志类型（如登录日志、业务日志、异常日志）
     * 表 : log
     * 对应字段 : type
     */
    private String type;

    /**
     * 操作名称
     * 表 : log
     * 对应字段 : operation
     */
    private String operation;

    /**
     * 产生日志的用户
     * 表 : log
     * 对应字段 : username
     */
    private String username;

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
    public Log(Integer id, String type, String operation, String username, Integer status, String message, Date createTime) {
        this.id = id;
        this.type = type;
        this.operation = operation;
        this.username = username;
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
     * @return log.type：日志类型（如登录日志、业务日志、异常日志）
     */
    public String getType() {
        return type;
    }

    /**
     * set method 
     *
     * @param type  日志类型（如登录日志、业务日志、异常日志）
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * get method 
     *
     * @return log.operation：操作名称
     */
    public String getOperation() {
        return operation;
    }

    /**
     * set method 
     *
     * @param operation  操作名称
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * get method 
     *
     * @return log.username：产生日志的用户
     */
    public String getUsername() {
        return username;
    }

    /**
     * set method 
     *
     * @param username  产生日志的用户
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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