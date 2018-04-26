package com.freight.ms.common.constant;

/**
 * Created by wyq on 2018/4/26.
 */
public enum ActivityEnum {
    ACTIVITY_STATUS_FUTURE(1, "未开始"),
    ACTIVITY_STATUS_NOW(2, "进行中"),
    ACTIVITY_STATUS_PAST(3, "已结束");

    private int code;
    private String name;

    ActivityEnum(int code, String name) {
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
