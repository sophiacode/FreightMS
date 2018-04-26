package com.freight.ms.wrapper;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.model.Driver;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DriverWrapper extends BaseWrapper{
    public DriverWrapper(List<Driver> obj) {
        super(obj);
    }

    public DriverWrapper(Driver obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
