package com.freight.ms.common.constant;

public enum ComplaintEnum {
    COMPLAINT_TYPE_CONSIGNOR(1, "货主投诉"),
    COMPLAINT_TYPE_DRIVER(2, "车主投诉"),

    COMPLAINT_STATUS_WAITING(1, "待处理"),
    COMPLAINT_STATUS_HANDLED(2, "已处理");

    private int code;
    private String name;

    ComplaintEnum(int code, String name) {
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
