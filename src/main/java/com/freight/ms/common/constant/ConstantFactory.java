package com.freight.ms.common.constant;

public class ConstantFactory {
    public static String getUserStatus(int code){
        if(code == UserEnum.USER_STATUS_FREEZE.getCode()){
            return UserEnum.USER_STATUS_FREEZE.getName();
        }else if(code == UserEnum.USER_STATUS_OK.getCode()){
            return UserEnum.USER_STATUS_OK.getName();
        }

        return "";
    }

    public static String getUserSex(int code){
        if(code == UserEnum.USER_SEX_MAN.getCode()){
            return UserEnum.USER_SEX_MAN.getName();
        }else if(code == UserEnum.USER_SEX_WOMAN.getCode()){
            return UserEnum.USER_SEX_WOMAN.getName();
        }

        return "";
    }

    public static String getUserType(int code){
        if(code == UserEnum.USER_TYPE_NORMAL.getCode()){
            return UserEnum.USER_TYPE_NORMAL.getName();
        }else if(code == UserEnum.USER_TYPE_ADMIN.getCode()){
            return UserEnum.USER_TYPE_ADMIN.getName();
        }

        return "";
    }

    public static String getLogStatus(int code){
        if(code == LogEnum.LOG_STATUS_FAIL.getCode()){
            return LogEnum.LOG_STATUS_FAIL.getName();
        }else if(code == LogEnum.LOG_STATUS_SUCCESS.getCode()){
            return LogEnum.LOG_STATUS_SUCCESS.getName();
        }

        return "";
    }

    public static String getConsignorStatus(int code){
        if(code == ConsignorEnum.CONSIGNOR_STATUS_FREEZE.getCode()){
            return ConsignorEnum.CONSIGNOR_STATUS_FREEZE.getName();
        }else if(code == ConsignorEnum.CONSIGNOR_STATUS_OK.getCode()){
            return ConsignorEnum.CONSIGNOR_STATUS_OK.getName();
        }

        return "";
    }

    public static String getDriverStatus(int code){
        if(code == DriverEnum.DRIVER_STATUS_OK.getCode()){
            return DriverEnum.DRIVER_STATUS_OK.getName();
        }else if(code == DriverEnum.DRIVER_STATUS_FREEZE.getCode()){
            return DriverEnum.DRIVER_STATUS_FREEZE.getName();
        }

        return "";
    }

    public static String getDriverAuthState(int code){
        if(code == DriverEnum.DRIVER_AUTH_YET.getCode()){
            return DriverEnum.DRIVER_AUTH_YET.getName();
        }else if(code == DriverEnum.DRIVER_AUTH_DOING.getCode()){
            return DriverEnum.DRIVER_AUTH_DOING.getName();
        }else if(code == DriverEnum.DRIVER_AUTH_SUCCESS.getCode()){
            return DriverEnum.DRIVER_AUTH_SUCCESS.getName();
        }else if(code == DriverEnum.DRIVER_AUTH_FAIL.getCode()){
            return DriverEnum.DRIVER_AUTH_FAIL.getName();
        }

        return "";
    }

    public static String getDriverOnlineState(int code){
        if(code == DriverEnum.DRIVER_ONLINE_YES.getCode()){
            return DriverEnum.DRIVER_ONLINE_YES.getName();
        }else if(code == DriverEnum.DRIVER_ONLINE_NO.getCode()){
            return DriverEnum.DRIVER_ONLINE_NO.getName();
        }

        return "";
    }

    public static String getDriverWorkState(int code){
        if(code == DriverEnum.DRIVER_WORK_YES.getCode()){
            return DriverEnum.DRIVER_WORK_YES.getName();
        }else if(code == DriverEnum.DRIVER_WORK_NO.getCode()){
            return DriverEnum.DRIVER_WORK_NO.getName();
        }

        return "";
    }

    public static String getActivityStatus(int code) {
        if(code == ActivityEnum.ACTIVITY_STATUS_FUTURE.getCode()){
            return ActivityEnum.ACTIVITY_STATUS_FUTURE.getName();
        }else if(code == ActivityEnum.ACTIVITY_STATUS_NOW.getCode()){
            return ActivityEnum.ACTIVITY_STATUS_NOW.getName();
        }else if(code == ActivityEnum.ACTIVITY_STATUS_PAST.getCode()){
            return ActivityEnum.ACTIVITY_STATUS_PAST.getName();
        }

        return "";
    }

    public static String getGoodsStatus(int code) {
        if(code == GoodsEnum.GOODS_STATUS_OK.getCode()){
            return GoodsEnum.GOODS_STATUS_OK.getName();
        }else if(code == GoodsEnum.GOODS_STATUS_NO.getCode()){
            return GoodsEnum.GOODS_STATUS_NO.getName();
        }

        return "";
    }

    public static String getOrderStatus(int code) {
        if(code == OrderEnum.ORDER_STATUS_WAITING.getCode()){
            return OrderEnum.ORDER_STATUS_WAITING.getName();
        }else if(code == OrderEnum.ORDER_STATUS_PROCESS.getCode()){
            return OrderEnum.ORDER_STATUS_PROCESS.getName();
        }else if(code == OrderEnum.ORDER_STATUS_FINISH.getCode()){
            return OrderEnum.ORDER_STATUS_FINISH.getName();
        }else if(code == OrderEnum.ORDER_STATUS_CANCEL.getCode()){
            return OrderEnum.ORDER_STATUS_CANCEL.getName();
        }

        return "";
    }

    public static String getOrderPayStatus(int code){
        if(code == OrderEnum.ORDER_PAY_YES.getCode()){
            return OrderEnum.ORDER_PAY_YES.getName();
        }else if(code == OrderEnum.ORDER_PAY_NO.getCode()){
            return OrderEnum.ORDER_PAY_NO.getName();
        }

        return "";
    }

    public static String getComplaintStatus(int code){
        if(code == ComplaintEnum.COMPLAINT_STATUS_WAITING.getCode()){
            return ComplaintEnum.COMPLAINT_STATUS_WAITING.getName();
        }else if(code == ComplaintEnum.COMPLAINT_STATUS_HANDLED.getCode()){
            return ComplaintEnum.COMPLAINT_STATUS_HANDLED.getName();
        }

        return "";
    }

    public static String getComplaintType(int code){
        if(code == ComplaintEnum.COMPLAINT_TYPE_CONSIGNOR.getCode()){
            return ComplaintEnum.COMPLAINT_TYPE_CONSIGNOR.getName();
        }else if(code == ComplaintEnum.COMPLAINT_TYPE_DRIVER.getCode()){
            return ComplaintEnum.COMPLAINT_TYPE_DRIVER.getName();
        }

        return "";
    }
}
