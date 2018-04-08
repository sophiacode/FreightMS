package com.freight.ms.model;

import java.util.Date;

public class Evaluation {
    /**
     * 评价id
     * 表 : evaluation
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 车主id
     * 表 : evaluation
     * 对应字段 : driver_id
     */
    private Integer driverId;

    /**
     * 货主id
     * 表 : evaluation
     * 对应字段 : consignor_id
     */
    private Integer consignorId;

    /**
     * 类型（1：货主评价车主，2：车主评价货主）
     * 表 : evaluation
     * 对应字段 : type
     */
    private Integer type;

    /**
     * 评价等级
     * 表 : evaluation
     * 对应字段 : grade
     */
    private String grade;

    /**
     * 评价内容
     * 表 : evaluation
     * 对应字段 : content
     */
    private String content;

    /**
     * 创建时间
     * 表 : evaluation
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     *
     */
    public Evaluation(Integer id, Integer driverId, Integer consignorId, Integer type, String grade, String content, Date createTime) {
        this.id = id;
        this.driverId = driverId;
        this.consignorId = consignorId;
        this.type = type;
        this.grade = grade;
        this.content = content;
        this.createTime = createTime;
    }

    /**
     *
     */
    public Evaluation() {
        super();
    }

    /**
     * get method 
     *
     * @return evaluation.id：评价id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  评价id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return evaluation.driver_id：车主id
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * set method 
     *
     * @param driverId  车主id
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    /**
     * get method 
     *
     * @return evaluation.consignor_id：货主id
     */
    public Integer getConsignorId() {
        return consignorId;
    }

    /**
     * set method 
     *
     * @param consignorId  货主id
     */
    public void setConsignorId(Integer consignorId) {
        this.consignorId = consignorId;
    }

    /**
     * get method 
     *
     * @return evaluation.type：类型（1：货主评价车主，2：车主评价货主）
     */
    public Integer getType() {
        return type;
    }

    /**
     * set method 
     *
     * @param type  类型（1：货主评价车主，2：车主评价货主）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * get method 
     *
     * @return evaluation.grade：评价等级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * set method 
     *
     * @param grade  评价等级
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    /**
     * get method 
     *
     * @return evaluation.content：评价内容
     */
    public String getContent() {
        return content;
    }

    /**
     * set method 
     *
     * @param content  评价内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * get method 
     *
     * @return evaluation.create_time：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * set method 
     *
     * @param createTime  创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}