package com.freight.ms.model;

import java.util.Date;

public class Activity {
    /**
     * 活动id
     * 表 : activity
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 标题
     * 表 : activity
     * 对应字段 : title
     */
    private String title;

    /**
     * 内容
     * 表 : activity
     * 对应字段 : content
     */
    private String content;

    /**
     * 发布用户的id
     * 表 : activity
     * 对应字段 : author_id
     */
    private Integer authorId;

    /**
     * 宣传图的地址
     * 表 : activity
     * 对应字段 : banner
     */
    private String banner;

    /**
     * 状态（1：未开始，2：进行中，3：已结束）
     * 表 : activity
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 创建时间
     * 表 : activity
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : activity
     * 对应字段 : update_time
     */
    private Date updateTime;

    /**
     *
     */
    public Activity(Integer id, String title, String content, Integer authorId, String banner, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.banner = banner;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Activity() {
        super();
    }

    /**
     * get method 
     *
     * @return activity.id：活动id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  活动id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return activity.title：标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * set method 
     *
     * @param title  标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * get method 
     *
     * @return activity.content：内容
     */
    public String getContent() {
        return content;
    }

    /**
     * set method 
     *
     * @param content  内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * get method 
     *
     * @return activity.author_id：发布用户的id
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * set method 
     *
     * @param authorId  发布用户的id
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * get method 
     *
     * @return activity.banner：宣传图的地址
     */
    public String getBanner() {
        return banner;
    }

    /**
     * set method 
     *
     * @param banner  宣传图的地址
     */
    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }

    /**
     * get method 
     *
     * @return activity.status：状态（1：未开始，2：进行中，3：已结束）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  状态（1：未开始，2：进行中，3：已结束）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return activity.create_time：创建时间
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

    /**
     * get method 
     *
     * @return activity.update_time：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * set method 
     *
     * @param updateTime  更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}