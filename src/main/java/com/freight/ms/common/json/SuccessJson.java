package com.freight.ms.common.json;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wyq on 2018/4/12.
 */
public class SuccessJson {
    public static String getJson(String msg){
        JSONObject object = new JSONObject();

        object.put("code", 0);
        object.put("msg", msg);

        return object.toJSONString();
    }

    public static String getJson(String msg, String url){
        JSONObject object = new JSONObject();

        object.put("code", 0);
        object.put("msg", msg);
        object.put("url", url);

        return object.toJSONString();
    }
}
