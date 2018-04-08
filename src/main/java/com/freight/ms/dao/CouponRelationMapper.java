package com.freight.ms.dao;

import com.freight.ms.model.CouponRelation;

public interface CouponRelationMapper {
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
    int insert(CouponRelation record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(CouponRelation record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    CouponRelation selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(CouponRelation record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(CouponRelation record);
}