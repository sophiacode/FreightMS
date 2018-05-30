package com.freight.ms.common.constant;

/**
 * Created by Sophia on 2018/5/29.
 */
public enum OrderEnum {
    ORDER_STATUS_WAITING(1, "等待接单"),
    ORDER_STATUS_PROCESS(2, "司机运输中"),
    ORDER_STATUS_FINISH(3, "已完成"),
    ORDER_STATUS_CANCEL(4, "已取消"),

    ORDER_PAY_NO(1, "未付款"),
    ORDER_PAY_YES(2, "已付款");

    private int code;
    private String name;

    OrderEnum(int code, String name) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
