package com.freight.ms.dao;

import com.freight.ms.model.Order;

public interface OrderMapper {
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
    int insert(Order record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Order record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Order record);
}