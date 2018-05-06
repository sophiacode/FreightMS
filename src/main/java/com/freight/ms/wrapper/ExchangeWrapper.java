package com.freight.ms.wrapper;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.model.Goods;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExchangeWrapper extends BaseWrapper{
    public ExchangeWrapper(List<Goods> obj) {
        super(obj);
    }

    public ExchangeWrapper(Goods obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        if(map.containsKey("status")){
            map.put("status", ConstantFactory.getGoodsStatus( (Integer)map.get("status")));
        }

        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
