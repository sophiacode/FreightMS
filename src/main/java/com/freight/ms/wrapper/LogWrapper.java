package com.freight.ms.wrapper;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.model.Log;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class LogWrapper extends BaseWrapper{
    public LogWrapper(List<Log> obj) {
        super(obj);
    }

    public LogWrapper(Log obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("status", ConstantFactory.getLogStatus((Integer) map.get("status")));
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
