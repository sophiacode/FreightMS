package com.freight.ms.dao;

import com.freight.ms.model.Exchange;

import java.util.List;
import java.util.Map;

public interface ExchangeMapper {
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
    int insert(Exchange record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Exchange record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Exchange selectByPrimaryKey(Integer id);

    List<Exchange> selectByGoodsId(Integer goodsId);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Exchange record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Exchange record);

    int getDriverPoint(Map<String, Object> map);

    int getConsignorPoint(Map<String, Object> map);
}