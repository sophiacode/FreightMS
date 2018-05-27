package com.freight.ms.dao;

import com.freight.ms.model.Consignor;

import java.util.List;
import java.util.Map;

public interface ConsignorMapper {
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
    int insert(Consignor record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Consignor record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Consignor selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Consignor record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Consignor record);

    List<Consignor> selectByParams(Map<String, Object> paramMap);

    int getCount();

    int getCountByTime(Map<String, Object> paramMap);

    Consignor selectByName(String name);
}