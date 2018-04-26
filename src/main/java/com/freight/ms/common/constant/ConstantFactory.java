package com.freight.ms.common.constant;

/**
 * Created by wyq on 2018/4/14.
 */

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
}
