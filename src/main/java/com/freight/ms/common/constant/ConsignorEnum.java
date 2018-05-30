package com.freight.ms.common.constant;

public enum ConsignorEnum {
    CONSIGNOR_STATUS_OK(1, "正常"),
    CONSIGNOR_STATUS_FREEZE(2, "冻结");

    private int code;
    private String name;

    ConsignorEnum(int code, String name) {
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
