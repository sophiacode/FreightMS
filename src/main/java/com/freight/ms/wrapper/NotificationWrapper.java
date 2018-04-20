package com.freight.ms.wrapper;

/**
 * Created by wyq on 2018/4/20.
 */

import com.freight.ms.model.Notification;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class NotificationWrapper extends BaseWrapper{
    public NotificationWrapper(List<Notification> obj) {
        super(obj);
    }

    public NotificationWrapper(Notification obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}

