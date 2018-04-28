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
        map.put("status", ConstantFactory.getDriverStatus((Integer) map.get("status")));
        map.put("authState", ConstantFactory.getDriverAuthState((Integer) map.get("authState")));
        map.put("onlineState", ConstantFactory.getDriverOnlineState((Integer) map.get("onlineState")));
        map.put("workState", ConstantFactory.getDriverWorkState((Integer) map.get("workState")));
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
