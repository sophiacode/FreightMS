package com.freight.ms.model;

public class Operation {
    /**
     * 菜单id
     * 表 : operation
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 菜单url地址
     * 表 : operation
     * 对应字段 : url
     */
    private String url;

    /**
     *
     */
    public Operation(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    /**
     *
     */
    public Operation() {
        super();
    }

    /**
     * get method 
     *
     * @return operation.id：菜单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  菜单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return operation.url：菜单url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * set method 
     *
     * @param url  菜单url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}