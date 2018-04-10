package com.freight.ms.common.exception;

import com.alibaba.fastjson.JSON;

/**
 * Created by wyq on 2018/4/10.
 */
public class BusinessException extends RuntimeException{
    private int code;
    private String msg;

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(BusinessEnumException exception){
        this.code = exception.getCode();
        this.msg = exception.getMsg();
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

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
