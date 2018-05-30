package com.freight.ms.model;

public class Report {
    private int orderTotal;     //总订单数
    private int orderProcess;   //进行中订单数
    private int orderFinish;    //完成订单数
    private int orderCancel;    //取消订单数
    private int complaintCount; //投诉数
    private double priceTotal;  //总成交金额
    private int pointDriver;    //车主兑换积分
    private int pointConsignor; //货主兑换积分

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getOrderProcess() {
        return orderProcess;
    }

    public void setOrderProcess(int orderProcess) {
        this.orderProcess = orderProcess;
    }

    public int getOrderFinish() {
        return orderFinish;
    }

    public void setOrderFinish(int orderFinish) {
        this.orderFinish = orderFinish;
    }

    public int getOrderCancel() {
        return orderCancel;
    }

    public void setOrderCancel(int orderCancel) {
        this.orderCancel = orderCancel;
    }

    public int getComplaintCount() {
        return complaintCount;
    }

    public void setComplaintCount(int complaintCount) {
        this.complaintCount = complaintCount;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public int getPointDriver() {
        return pointDriver;
    }

    public void setPointDriver(int pointDriver) {
        this.pointDriver = pointDriver;
    }

    public int getPointConsignor() {
        return pointConsignor;
    }

    public void setPointConsignor(int pointConsignor) {
        this.pointConsignor = pointConsignor;
    }
}
