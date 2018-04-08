package com.freight.ms.model;

import java.util.Date;

public class Goods {
    /**
     * 积分兑换物品id
     * 表 : goods
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 物品名称
     * 表 : goods
     * 对应字段 : name
     */
    private String name;

    /**
     * 所需积分
     * 表 : goods
     * 对应字段 : point
     */
    private Integer point;

    /**
     * 状态（1：当前可兑换，2：当前不可兑换）
     * 表 : goods
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 创建时间
     * 表 : goods
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : goods
     * 对应字段 : update_time
     */
    private Date updateTime;

    /**
     *
     */
    public Goods(Integer id, String name, Integer point, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Goods() {
        super();
    }

    /**
     * get method 
     *
     * @return goods.id：积分兑换物品id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  积分兑换物品id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return goods.name：物品名称
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  物品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return goods.point：所需积分
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * set method 
     *
     * @param point  所需积分
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * get method 
     *
     * @return goods.status：状态（1：当前可兑换，2：当前不可兑换）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  状态（1：当前可兑换，2：当前不可兑换）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return goods.create_time：创建时间
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
     * @return goods.update_time：更新时间
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