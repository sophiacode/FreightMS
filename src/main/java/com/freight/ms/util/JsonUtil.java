package com.freight.ms.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
    public static String getTableListJson(int count, Object list){
        JSONObject object = new JSONObject();
        object.put("total", count);
        object.put("rows", list);
        return object.toJSONString();
    }
}
