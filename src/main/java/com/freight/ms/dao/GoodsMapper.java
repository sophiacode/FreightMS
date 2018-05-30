package com.freight.ms.dao;

import com.freight.ms.model.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
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
    int insert(Goods record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Goods record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Goods selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Goods record);

    List<Goods> selectByParams(Map<String, Object> paramMap);

    int getCount(Map<String, Object> paramMap);
}