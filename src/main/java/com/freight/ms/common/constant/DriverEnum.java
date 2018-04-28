package com.freight.ms.common.constant;

/**
 * Created by wyq on 2018/4/28.
 */
public enum DriverEnum {
    DRIVER_STATUS_OK(0, "正常"),
    DRIVER_STATUS_FREEZE(1, "冻结"),
    DRIVER_AUTH_YET(1, "未认证"),
    DRIVER_AUTH_DOING(2, "认证申请中"),
    DRIVER_AUTH_SUCCESS(3, "认证通过"),
    DRIVER_AUTH_FAIL(4, "认证失败"),
    DRIVER_ONLINE_YES(1, "在线"),
    DRIVER_ONLINE_NO(2, "不在线"),
    DRIVER_WORK_YES(1, "已接单"),
    DRIVER_WORK_NO(2, "未接单");

    private int code;
    private String name;

    DriverEnum(int code, String name) {
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
