package com.freight.ms.common.constant;

/**
 * Created by wyq on 2018/4/26.
 */
public enum GoodsEnum {
    GOODS_STATUS_OK(1, "当前可兑换"),
    GOODS_STATUS_NO(2, "当前不可兑换");

    private int code;
    private String name;

    GoodsEnum(int code, String name) {
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
