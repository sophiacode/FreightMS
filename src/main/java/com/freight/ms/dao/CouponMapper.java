package com.freight.ms.dao;

import com.freight.ms.model.Coupon;

import java.util.List;
import java.util.Map;

public interface CouponMapper {
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
    int insert(Coupon record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Coupon record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Coupon selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Coupon record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Coupon record);

    List<Coupon> selectByParams(Map<String, Object> paramMap);

    int getCount(Map<String, Object> paramMap);
}