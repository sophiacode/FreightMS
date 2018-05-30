package com.freight.ms.model;

import java.util.Date;

public class Order {
    /**
     * 订单id
     * 表 : order
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 订单号
     * 表 : order
     * 对应字段 : order_no
     */
    private String orderNo;

    /**
     * 货主用户id
     * 表 : order
     * 对应字段 : consignor_id
     */
    private Integer consignorId;

    /**
     * 车主用户id
     * 表 : order
     * 对应字段 : driver_id
     */
    private Integer driverId;

    /**
     * 收货人姓名
     * 表 : order
     * 对应字段 : receiver_name
     */
    private String receiverName;

    /**
     * 收货人电话
     * 表 : order
     * 对应字段 : receiver_phone
     */
    private String receiverPhone;

    /**
     * 发货地址
     * 表 : order
     * 对应字段 : start_address
     */
    private String startAddress;

    /**
     * 收货地址
     * 表 : order
     * 对应字段 : end_address
     */
    private String endAddress;

    /**
     * 订单价格
     * 表 : order
     * 对应字段 : price
     */
    private Double price;

    /**
     * 优惠券id
     * 表 : order
     * 对应字段 : coupon_id
     */
    private Integer couponId;

    /**
     * 距离
     * 表 : order
     * 对应字段 : distance
     */
    private Double distance;

    /**
     * 货物类型
     * 表 : order
     * 对应字段 : goods_type
     */
    private String goodsType;

    /**
     * 备注信息
     * 表 : order
     * 对应字段 : remark
     */
    private String remark;

    /**
     * 订单状态（1：等待接单，2：司机运输中，3：已完成，4：已取消）
     * 表 : order
     * 对应字段 : order_status
     */
    private Integer orderStatus;

    /**
     * 付款状态（1：未付款，2：已付款）
     * 表 : order
     * 对应字段 : pay_status
     */
    private Integer payStatus;

    /**
     * 创建时间
     * 表 : order
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : order
     * 对应字段 : update_time
     */
    private Date updateTime;

    private String driverName;

    private String consignorName;

    /**
     *
     */
    public Order(Integer id, String orderNo, Integer consignorId, Integer driverId, String receiverName, String receiverPhone, String startAddress, String endAddress, Double price, Integer couponId, Double distance, String goodsType, String remark, Integer orderStatus, Integer payStatus, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.consignorId = consignorId;
        this.driverId = driverId;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.price = price;
        this.couponId = couponId;
        this.distance = distance;
        this.goodsType = goodsType;
        this.remark = remark;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Order() {
        super();
    }

    /**
     * get method 
     *
     * @return order.id：订单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  订单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return order.order_no：订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * set method 
     *
     * @param orderNo  订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * get method 
     *
     * @return order.consignor_id：货主用户id
     */
    public Integer getConsignorId() {
        return consignorId;
    }

    /**
     * set method 
     *
     * @param consignorId  货主用户id
     */
    public void setConsignorId(Integer consignorId) {
        this.consignorId = consignorId;
    }

    /**
     * get method 
     *
     * @return order.driver_id：车主用户id
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * set method 
     *
     * @param driverId  车主用户id
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    /**
     * get method 
     *
     * @return order.receiver_name：收货人姓名
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
     * @return order.receiver_phone：收货人电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * set method 
     *
     * @param receiverPhone  收货人电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    /**
     * get method 
     *
     * @return order.start_address：发货地址
     */
    public String getStartAddress() {
        return startAddress;
    }

    /**
     * set method 
     *
     * @param startAddress  发货地址
     */
    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress == null ? null : startAddress.trim();
    }

    /**
     * get method 
     *
     * @return order.end_address：收货地址
     */
    public String getEndAddress() {
        return endAddress;
    }

    /**
     * set method 
     *
     * @param endAddress  收货地址
     */
    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress == null ? null : endAddress.trim();
    }

    /**
     * get method 
     *
     * @return order.price：订单价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * set method 
     *
     * @param price  订单价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * get method 
     *
     * @return order.coupon_id：优惠券id
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
     * @return order.distance：距离
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * set method 
     *
     * @param distance  距离
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * get method 
     *
     * @return order.goods_type：货物类型
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * set method 
     *
     * @param goodsType  货物类型
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    /**
     * get method 
     *
     * @return order.remark：备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set method 
     *
     * @param remark  备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * get method 
     *
     * @return order.order_status：订单状态（1：等待接单，2：司机运输中，3：已完成，4：已取消）
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * set method 
     *
     * @param orderStatus  订单状态（1：等待接单，2：司机运输中，3：已完成，4：已取消）
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * get method 
     *
     * @return order.pay_status：付款状态（1：未付款，2：已付款）
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * set method 
     *
     * @param payStatus  付款状态（1：未付款，2：已付款）
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * get method 
     *
     * @return order.create_time：创建时间
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
     * @return order.update_time：更新时间
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
    }
}