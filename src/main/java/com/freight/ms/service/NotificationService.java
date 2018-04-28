package com.freight.ms.service;

import com.freight.ms.model.Notification;

import java.util.List;
import java.util.Map;

public interface NotificationService {

    Notification findNotificationById(Integer id);

    String findNotifications(Map<String, Object> paramMap);

    List<Notification> findAll();

    void addNotification(Notification notification);

    void editNotification(Notification notification);

    void deleteNotifications(List<Integer> list);
}
