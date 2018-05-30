package com.freight.ms.wrapper;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.model.Complaint;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ComplaintWrapper extends BaseWrapper{
    public ComplaintWrapper(List<Complaint> obj) {
        super(obj);
    }

    public ComplaintWrapper(Complaint obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("type", ConstantFactory.getComplaintType( (Integer)map.get("type")));
        map.put("status", ConstantFactory.getComplaintStatus( (Integer)map.get("status")));
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
