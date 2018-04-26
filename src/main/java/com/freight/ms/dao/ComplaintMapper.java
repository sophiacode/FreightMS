package com.freight.ms.dao;

import com.freight.ms.model.Complaint;

import java.util.List;
import java.util.Map;

public interface ComplaintMapper {
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
    int insert(Complaint record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Complaint record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Complaint selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Complaint record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Complaint record);

    List<Complaint> selectByParams(Map<String, Object> paramMap);

    int getCount();
}