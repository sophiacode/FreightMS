package com.freight.ms.common.constant;

public enum LogEnum {
    LOG_STATUS_SUCCESS(1, "成功"),
    LOG_STATUS_FAIL(2, "失败");

    private int code;
    private String name;

    LogEnum(int code, String name) {
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
