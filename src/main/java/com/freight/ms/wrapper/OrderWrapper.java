package com.freight.ms.wrapper;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.model.Order;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderWrapper extends BaseWrapper{
    public OrderWrapper(List<Order> obj) {
        super(obj);
    }

    public OrderWrapper(Order obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("orderStatus", ConstantFactory.getOrderStatus( (Integer)map.get("orderStatus")));
        map.put("payStatus", ConstantFactory.getOrderPayStatus( (Integer)map.get("payStatus")));
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
