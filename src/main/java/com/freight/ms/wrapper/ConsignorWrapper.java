package com.freight.ms.wrapper;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.model.Consignor;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ConsignorWrapper extends BaseWrapper{
    public ConsignorWrapper(List<Consignor> obj) {
        super(obj);
    }

    public ConsignorWrapper(Consignor obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
