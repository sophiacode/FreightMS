package com.freight.ms.model;

import java.util.Date;

public class Coupon {
    /**
     * 优惠券id
     * 表 : coupon
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 优惠券名称
     * 表 : coupon
     * 对应字段 : name
     */
    private String name;

    /**
     * 有效时间（单位：天）
     * 表 : coupon
     * 对应字段 : active_time
     */
    private Integer activeTime;

    /**
     * 优惠价格
     * 表 : coupon
     * 对应字段 : price
     */
    private Double price;

    /**
     * 可使用优惠券的起始价格
     * 表 : coupon
     * 对应字段 : start_price
     */
    private Double startPrice;

    /**
     * 创建时间
     * 表 : coupon
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : coupon
     * 对应字段 : update_time
     */
    private Date updateTime;

    /**
     *
     */
    public Coupon(Integer id, String name, Integer activeTime, Double price, Double startPrice, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.activeTime = activeTime;
        this.price = price;
        this.startPrice = startPrice;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Coupon() {
        super();
    }

    /**
     * get method 
     *
     * @return coupon.id：优惠券id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  优惠券id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return coupon.name：优惠券名称
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  优惠券名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return coupon.active_time：有效时间（单位：天）
     */
    public Integer getActiveTime() {
        return activeTime;
    }

    /**
     * set method 
     *
     * @param activeTime  有效时间（单位：天）
     */
    public void setActiveTime(Integer activeTime) {
        this.activeTime = activeTime;
    }

    /**
     * get method 
     *
     * @return coupon.price：优惠价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * set method 
     *
     * @param price  优惠价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * get method 
     *
     * @return coupon.start_price：可使用优惠券的起始价格
     */
    public Double getStartPrice() {
        return startPrice;
    }

    /**
     * set method 
     *
     * @param startPrice  可使用优惠券的起始价格
     */
    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    /**
     * get method 
     *
     * @return coupon.create_time：创建时间
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
     * @return coupon.update_time：更新时间
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