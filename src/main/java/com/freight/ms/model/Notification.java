package com.freight.ms.model;

import java.util.Date;

public class Notification {
    /**
     * 通知id
     * 表 : notification
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 通知标题
     * 表 : notification
     * 对应字段 : title
     */
    private String title;

    /**
     * 通知内容
     * 表 : notification
     * 对应字段 : content
     */
    private String content;

    /**
     * 发布人的id
     * 表 : notification
     * 对应字段 : author_id
     */
    private Integer authorId;

    /**
     * 创建时间
     * 表 : notification
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : notification
     * 对应字段 : update_time
     */
    private Date updateTime;

    private String authorName;

    /**
     *
     */
    public Notification(Integer id, String title, String content, Integer authorId, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Notification() {
        super();
    }

    /**
     * get method 
     *
     * @return notification.id：通知id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  通知id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return notification.title：通知标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * set method 
     *
     * @param title  通知标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * get method 
     *
     * @return notification.content：通知内容
     */
    public String getContent() {
        return content;
    }

    /**
     * set method 
     *
     * @param content  通知内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * get method 
     *
     * @return notification.author_id：发布人的id
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * set method 
     *
     * @param authorId  发布人的id
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * get method 
     *
     * @return notification.create_time：创建时间
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
     * @return notification.update_time：更新时间
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}