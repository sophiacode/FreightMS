package com.freight.ms.util;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wyq on 2018/4/10.
 */
public class JsonUtil {
    public String getJson(int code, String msg){
        JSONObject object = new JSONObject();
        object.put("code", code);
        object.put("msg", msg);
        return object.toJSONString();
    }

}
