package com.freight.ms.dao;

import com.freight.ms.model.Evaluation;

public interface EvaluationMapper {
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
    int insert(Evaluation record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Evaluation record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Evaluation selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Evaluation record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Evaluation record);
}