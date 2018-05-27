package com.freight.ms.serviceImpl;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.ActivityMapper;
import com.freight.ms.model.Activity;
import com.freight.ms.service.ActivityService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.ActivityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    private ActivityMapper activityMapper;

    public Activity findActivityById(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    public String findActivitys(Map<String, Object> paramMap){
        List<Activity> activityList = activityMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(activityMapper.getCount(),
                        new ActivityWrapper(activityList).wrap());
    }

    public void addActivity(Activity activity){
        try{
            activityMapper.insertSelective(activity);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.ACTIVITY_ADD_FAIL);
        }
    }

    public void editActivity(Activity activity){
        try{
            activityMapper.updateByPrimaryKeySelective(activity);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.ACTIVITY_EDIT_FAIL);
        }
    }

    public void deleteActivitys(List<Integer> list){
        try{
            for(Integer id:list){
                activityMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.ACTIVITY_DELETE_FAIL);
        }
    }
}
