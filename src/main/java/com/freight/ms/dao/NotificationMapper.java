package com.freight.ms.dao;

import com.freight.ms.model.Notification;

import java.util.List;
import java.util.Map;

public interface NotificationMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(Notification record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Notification record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Notification selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Notification record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Notification record);

    List<Notification> selectByParams(Map<String, Object> paramMap);

    int getCount();
}