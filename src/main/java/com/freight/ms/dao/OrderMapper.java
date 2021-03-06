package com.freight.ms.dao;

import com.freight.ms.model.Order;

import java.util.List;
import java.util.Map;

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

    List<Order> selectByParams(Map<String, Object> paramMap);

    int getCount(Map<String, Object> paramMap);

    int getTotal(Map<String, Object> map);

    int getProcess(Map<String, Object> map);

    int getFinish(Map<String, Object> map);

    int getCancel(Map<String, Object> map);

    Double getPrice(Map<String, Object> map);

    Order selectByOrderNo(String orderNo);
}