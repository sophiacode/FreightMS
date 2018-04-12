package com.freight.ms.common.constant;

/**
 * Created by wyq on 2018/4/9.
 */
public enum UserEnum {
    USER_STATE_OK("正常", 0),
    USER_STATE_FREEZE("冻结", 1);

    private String name;
    private int code;

    UserEnum(String name, int code) {
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
