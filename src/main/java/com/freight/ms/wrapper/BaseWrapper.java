package com.freight.ms.wrapper;

import com.freight.ms.util.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseWrapper {
    Object obj = null;

    public BaseWrapper(Object obj){
        this.obj = obj;
    }

    public Object wrap(){
        if(obj instanceof List){
            List<Object> list = (List<Object>) obj;
            List<Map<String, Object>> mapList = new ArrayList<>();

            for(Object o: list){
                Map<String, Object> map = BeanUtil.transBean2Map(o);
                wrapMap(map);
                mapList.add(map);
            }
            return mapList;
        }else{
            Map<String, Object> map = BeanUtil.transBean2Map(obj);
            wrapMap(map);

            return map;
        }
    }

    protected abstract void wrapMap(Map<String, Object> map);
}
