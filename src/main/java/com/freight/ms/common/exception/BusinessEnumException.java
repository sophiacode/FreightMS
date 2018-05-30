package com.freight.ms.common.exception;

public enum BusinessEnumException {
    /**
     * 登录
     */
    LOGIN_ERROR(101, "用户名或密码错误"),
    LOGIN_USER_FREEZE(102, "该用户已被冻结"),
    LOGIN_ERROR_REPEATEDLY(103, "错误次数过多，请稍候再试"),
    LOGIN_UNKNOWN(104, "登陆失败"),


    /**
     * 用户管理
     */
    USER_NOT_FOUND(201, "该用户不存在"),
    USER_ADD_REPEAT(202, "该用户已存在，请使用其他用户名"),
    USER_ADD_FAIL(203, "添加失败"),
    USER_EDIT_FAIL(204, "修改失败"),
    USER_DELETE_FAIL(205, "删除失败"),
    USER_CHANGE_STATUS_FAIL(206, "修改用户状态失败"),
    USER_FREEZE_ADMIN_ERROR(207, "不能冻结超级管理员"),
    USER_SET_ROLE_ERROR(208, "分配角色失败"),
    USER_PASSWORD_ERROR(209, "旧密码错误"),
    USER_PASSWORD_CHANGE_FAIL(210, "修改密码失败"),

    /**
     * 角色管理
     */
    ROLE_ADD_FAIL(301, "添加角色失败"),
    ROLE_EDIT_FAIL(302, "修改角色失败"),
    ROLE_DELETE_FAIL(303, "删除角色失败"),
    ROLE_PERMISSION_FAIL(310, "更新权限失败"),

    /**
     * 通知管理
     */
    NOTIFICATION_ADD_FAIL(401, "添加通知失败"),
    NOTIFICATION_EDIT_FAIL(402, "修改通知失败"),
    NOTIFICATION_DELETE_FAIL(403, "删除通知失败"),

    /**
     * 货主用户管理
     */
    CONSIGNOR_CHANGE_STATUS_FAIL(501, "对货主用户的状态修改失败"),

    /**
     * 车主用户管理
     */
    DRIVER_CHANGE_STATUS_FAIL(601, "对车主用户的状态修改失败"),
    DRIVER_AUTH_FAIL(602, "对车主用户的认证状态修改失败"),

    /**
     * 投诉管理
     */
    COMPLAINT_HANDLE_FAIL(701, "添加投诉处理结果失败"),

    /**
     * 活动管理
     */
    ACTIVITY_ADD_FAIL(801, "添加活动失败"),
    ACTIVITY_EDIT_FAIL(802, "修改活动失败"),
    ACTIVITY_DELETE_FAIL(803, "删除活动失败"),

    /**
     * 优惠券管理
     */
    COUPON_ADD_FAIL(901, "添加优惠券失败"),
    COUPON_EDIT_FAIL(902, "修改优惠券失败"),
    COUPON_DELETE_FAIL(903, "删除优惠券失败"),
    COUPON_RELEASE_FAIL(904, "发放优惠券失败"),

    /**
     * 积分兑换管理
     */
    GOODS_ADD_FAIL(1001, "添加积分兑换物品失败"),
    GOODS_EDIT_FAIL(1002, "修改积分兑换物品失败"),
    GOODS_DELETE_FAIL(1003, "删除积分兑换物品失败"),

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
