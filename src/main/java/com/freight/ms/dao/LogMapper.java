package com.freight.ms.dao;

import com.freight.ms.model.Log;

import java.util.List;
import java.util.Map;

public interface LogMapper {
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
    int insert(Log record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Log record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Log selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Log record);

    List<Log> selectByParams(Map<String, Object> paramMap);

    int getCount();
}