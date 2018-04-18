package com.freight.ms.common.exception;

/**
 * Created by wyq on 2018/4/10.
 */
public enum BusinessEnumException {
    /**
     * 登录
     */
    LOGIN_ERROR(101, "用户名或密码错误"),
    LOGIN_USER_FREEZE(102, "该用户已被冻结"),
    LOGIN_UNKNOWN(103, "登陆失败"),

    /**
     * 用户管理
     */
    USER_NOT_FOUND(201, "该用户不存在"),
    USER_ADD_REPEAT(202, "该用户已存在，请使用其他用户名"),
    USER_ADD_FAIL(203, "添加用户失败"),
    USER_EDIT_FAIL(204, "修改用户失败"),
    USER_DELETE_FAIL(205, "删除用户失败"),
    USER_CHANGE_STATUS_FAIL(206, "修改用户状态失败"),
    USER_FREEZE_ADMIN_ERROR(207, "不能冻结超级管理员"),
    USER_SET_ROLE_ERROR(208, "分配角色失败"),

    /**
     * 其他
     */
    REQUEST_NULL(400, "错误的请求"),
    UNKNOWN_ERROR(1, "未知错误");

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
