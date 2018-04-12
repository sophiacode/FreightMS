package com.freight.ms.common.exception;

/**
 * Created by wyq on 2018/4/10.
 */
public enum BusinessEnumException {
    UNKNOWN_ERROR(001, "未知错误"),

    /**
     * 登录
     */
    LOGIN_ERROR(101, "用户名或密码错误"),
    LOGIN_USER_FREEZE(102, "该用户已被冻结"),
    LOGIN_UNKNOWN(103, "登陆失败");

    private int code;
    private String msg;

    BusinessEnumException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
