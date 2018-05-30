package com.freight.ms.common.constant;

public enum UserEnum{
    USER_SEX_MAN(1, "男"),
    USER_SEX_WOMAN(2, "女"),

    USER_STATUS_OK(0, "正常"),
    USER_STATUS_FREEZE(1, "冻结"),

    USER_TYPE_NORMAL(0, "普通用户"),
    USER_TYPE_ADMIN(1, "超级管理员");

    private int code;
    private String name;

    UserEnum(int code, String name) {
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
