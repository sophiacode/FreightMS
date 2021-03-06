package com.freight.ms.model;

import java.util.Date;

public class Complaint {
    /**
     * 投诉id
     * 表 : complaint
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 订单id
     * 表 : complaint
     * 对应字段 : order_id
     */
    private Integer orderId;

    /**
     * 投诉类型（1：货主投诉车主，2：车主投诉货主）
     * 表 : complaint
     * 对应字段 : type
     */
    private Integer type;

    /**
     * 投诉原因
     * 表 : complaint
     * 对应字段 : reason
     */
    private String reason;

    /**
     * 处理状态（1：待处理，2：已处理）
     * 表 : complaint
     * 对应字段 : status
     */
        private Integer status;

    /**
     * 处理投诉的管理系统用户id
     * 表 : complaint
     * 对应字段 : admin_id
     */
    private Integer adminId;

    /**
     * 对该投诉的处理说明
     * 表 : complaint
     * 对应字段 : process
     */
    private String process;

    private Date createTime;

    private Date updateTime;

    private String orderNo;

    private String adminName;

    /**
     *
     */
    public Complaint(Integer id, Integer orderId, Integer type, String reason, Integer status, Integer adminId, String process, Date createTime, Date updateTime) {
        this.id = id;
        this.orderId = orderId;
        this.type = type;
        this.reason = reason;
        this.status = status;
        this.adminId = adminId;
        this.process = process;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Complaint() {
        super();
    }

    /**
     * get method 
     *
     * @return complaint.id：投诉id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  投诉id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return complaint.order_id：订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * set method 
     *
     * @param orderId  订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * get method 
     *
     * @return complaint.type：投诉类型（1：货主投诉车主，2：车主投诉货主）
     */
    public Integer getType() {
        return type;
    }

    /**
     * set method 
     *
     * @param type  投诉类型（1：货主投诉车主，2：车主投诉货主）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * get method 
     *
     * @return complaint.reason：投诉原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * set method 
     *
     * @param reason  投诉原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * get method 
     *
     * @return complaint.status：处理状态（1：待处理，2：已处理）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  处理状态（1：待处理，2：已处理）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return complaint.admin_id：处理投诉的管理系统用户id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * set method 
     *
     * @param adminId  处理投诉的管理系统用户id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * get method 
     *
     * @return complaint.process：对该投诉的处理说明
     */
    public String getProcess() {
        return process;
    }

    /**
     * set method 
     *
     * @param process  对该投诉的处理说明
     */
    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}