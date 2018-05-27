package com.freight.ms.model;

import java.util.Date;

public class Exchange {
    /**
     * 积分兑换物品记录id
     * 表 : exchange
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 用户id
     * 表 : exchange
     * 对应字段 : user_id
     */
    private Integer userId;

    /**
     * 用户类型（1：车主，2：货主）
     * 表 : exchange
     * 对应字段 : user_type
     */
    private Integer userType;

    private String user;

    /**
     * 物品id
     * 表 : exchange
     * 对应字段 : goods_id
     */
    private Integer goodsId;

    /**
     * 收货人姓名
     * 表 : exchange
     * 对应字段 : receiver_name
     */
    private String receiverName;

    /**
     * 收货人电话
     * 表 : exchange
     * 对应字段 : receiver_telephone
     */
    private String receiverTelephone;

    /**
     * 收货人地址
     * 表 : exchange
     * 对应字段 : receiver_address
     */
    private String receiverAddress;

    /**
     * 创建时间
     * 表 : exchange
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     *
     */
    public Exchange(Integer id, Integer userId, Integer userType, Integer goodsId, String receiverName, String receiverTelephone, String receiverAddress, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.userType = userType;
        this.goodsId = goodsId;
        this.receiverName = receiverName;
        this.receiverTelephone = receiverTelephone;
        this.receiverAddress = receiverAddress;
        this.createTime = createTime;
    }

    /**
     *
     */
    public Exchange() {
        super();
    }

    /**
     * get method 
     *
     * @return exchange.id：积分兑换物品记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  积分兑换物品记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return exchange.user_id：用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * set method 
     *
     * @param userId  用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * get method 
     *
     * @return exchange.user_type：用户类型（1：车主，2：货主）
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * set method 
     *
     * @param userType  用户类型（1：车主，2：货主）
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * get method 
     *
     * @return exchange.goods_id：物品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * set method 
     *
     * @param goodsId  物品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * get method 
     *
     * @return exchange.receiver_name：收货人姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * set method 
     *
     * @param receiverName  收货人姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * get method 
     *
     * @return exchange.receiver_telephone：收货人电话
     */
    public String getReceiverTelephone() {
        return receiverTelephone;
    }

    /**
     * set method 
     *
     * @param receiverTelephone  收货人电话
     */
    public void setReceiverTelephone(String receiverTelephone) {
        this.receiverTelephone = receiverTelephone == null ? null : receiverTelephone.trim();
    }

    /**
     * get method 
     *
     * @return exchange.receiver_address：收货人地址
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * set method 
     *
     * @param receiverAddress  收货人地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    /**
     * get method 
     *
     * @return exchange.create_time：创建时间
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}