package com.freight.ms.wrapper;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.model.Activity;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ActivityWrapper extends BaseWrapper{
    public ActivityWrapper(List<Activity> obj) {
        super(obj);
    }

    public ActivityWrapper(Activity obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
