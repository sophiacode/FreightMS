package com.freight.ms.dao;

import com.freight.ms.model.Role;

public interface RoleMapper {
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
    int insert(Role record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(Role record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Role record);
}