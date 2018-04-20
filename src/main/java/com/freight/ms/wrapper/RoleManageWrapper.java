package com.freight.ms.wrapper;

import com.freight.ms.model.Role;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wyq on 2018/4/20.
 */
public class RoleManageWrapper extends BaseWrapper{
    public RoleManageWrapper(List<Role> obj) {
        super(obj);
    }

    public RoleManageWrapper(Role obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
