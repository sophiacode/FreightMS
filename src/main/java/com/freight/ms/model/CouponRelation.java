package com.freight.ms.model;

import java.util.Date;

public class CouponRelation {
    /**
     * 记录id
     * 表 : coupon_relation
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 货主id
     * 表 : coupon_relation
     * 对应字段 : consignor_id
     */
    private Integer consignorId;

    /**
     * 优惠券id
     * 表 : coupon_relation
     * 对应字段 : coupon_id
     */
    private Integer couponId;

    /**
     * 状态（1：未使用，2：已使用，3：已过期）
     * 表 : coupon_relation
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 使用该优惠券的订单id
     * 表 : coupon_relation
     * 对应字段 : order_id
     */
    private Integer orderId;

    /**
     * 创建时间
     * 表 : coupon_relation
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : coupon_relation
     * 对应字段 : update_time
     */
    private Date updateTime;

    /**
     *
     */
    public CouponRelation(Integer id, Integer consignorId, Integer couponId, Integer status, Integer orderId, Date createTime, Date updateTime) {
        this.id = id;
        this.consignorId = consignorId;
        this.couponId = couponId;
        this.status = status;
        this.orderId = orderId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public CouponRelation() {
        super();
    }

    /**
     * get method 
     *
     * @return coupon_relation.id：记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return coupon_relation.consignor_id：货主id
     */
    public Integer getConsignorId() {
        return consignorId;
    }

    /**
     * set method 
     *
     * @param consignorId  货主id
     */
    public void setConsignorId(Integer consignorId) {
        this.consignorId = consignorId;
    }

    /**
     * get method 
     *
     * @return coupon_relation.coupon_id：优惠券id
     */
    public Integer getCouponId() {
        return couponId;
    }

    /**
     * set method 
     *
     * @param couponId  优惠券id
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * get method 
     *
     * @return coupon_relation.status：状态（1：未使用，2：已使用，3：已过期）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  状态（1：未使用，2：已使用，3：已过期）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return coupon_relation.order_id：使用该优惠券的订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * set method 
     *
     * @param orderId  使用该优惠券的订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * get method 
     *
     * @return coupon_relation.create_time：创建时间
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
     * @return coupon_relation.update_time：更新时间
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