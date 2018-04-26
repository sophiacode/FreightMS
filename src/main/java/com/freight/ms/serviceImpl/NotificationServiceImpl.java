package com.freight.ms.serviceImpl;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.NotificationMapper;
import com.freight.ms.dao.UserMapper;
import com.freight.ms.model.Notification;
import com.freight.ms.service.NotificationService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.NotificationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private NotificationMapper notificationMapper;

    @Autowired
    private UserMapper userMapper;

    public Notification findNotificationById(Integer id) {
        return notificationMapper.selectByPrimaryKey(id);
    }

    public String findNotifications(Map<String, Object> paramMap){
        List<Notification> notificationList = notificationMapper.selectByParams(paramMap);
        for(Notification n:notificationList){
            if(n.getAuthorId()!=null){
                n.setAuthorName(userMapper.selectByPrimaryKey(n.getAuthorId()).getName());
            }
        }

        return JsonUtil.getTableListJson(notificationMapper.getCount(),
                        new NotificationWrapper(notificationList).wrap());
    }

    public void addNotification(Notification notification){
        try{
            notificationMapper.insertSelective(notification);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_ADD_FAIL);    //TODO:异常
        }
    }

    public void editNotification(Notification notification){
        try{
            notificationMapper.updateByPrimaryKeySelective(notification);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_EDIT_FAIL);   //TODO:异常
        }
    }

    public void deleteNotifications(List<Integer> list){
        try{
            for(Integer id:list){
                notificationMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_DELETE_FAIL);  //TODO:异常
        }
    }
}
