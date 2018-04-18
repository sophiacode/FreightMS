package com.freight.ms.wrapper;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.model.User;
import com.freight.ms.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wyq on 2018/4/13.
 */
public class UserManageWrapper extends BaseWrapper{
    public UserManageWrapper(List<User> obj) {
        super(obj);
    }

    public UserManageWrapper(User obj){
        super(obj);
    }

    @Override
    protected void wrapMap(Map<String, Object> map) {
        map.put("sex", ConstantFactory.getUserSex((Integer) map.get("sex")));
        map.put("status", ConstantFactory.getUserStatus((Integer) map.get("status")));
        map.put("type", ConstantFactory.getUserType((Integer) map.get("type")));
        map.put("createTime", DateUtil.format((Date) map.get("createTime"), "yyyy.MM.dd"));
    }
}
