package com.freight.ms.model;

import java.util.Date;

public class Driver {
    /**
     * 车主用户id
     * 表 : driver
     * 对应字段 : id
     */
    private Integer id;

    /**
     * 手机号码
     * 表 : driver
     * 对应字段 : telephone
     */
    private String telephone;

    /**
     * 密码
     * 表 : driver
     * 对应字段 : password
     */
    private String password;

    /**
     * 加密盐
     * 表 : driver
     * 对应字段 : salt
     */
    private String salt;

    /**
     * 姓名
     * 表 : driver
     * 对应字段 : name
     */
    private String name;

    /**
     * 账号状态（1：正常，2：冻结）
     * 表 : driver
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 认证状态（1：未认证，2：认证申请中，3：认证通过，4：认证失败）
     * 表 : driver
     * 对应字段 : auth_state
     */
    private Integer authState;

    /**
     * 在线状态（1：在线，2：不在线）
     * 表 : driver
     * 对应字段 : online_state
     */
    private Integer onlineState;

    /**
     * 接单状态（1：已接单，2：未接单）
     * 表 : driver
     * 对应字段 : work_state
     */
    private Integer workState;

    /**
     * 积分
     * 表 : driver
     * 对应字段 : point
     */
    private Integer point;

    /**
     * 评价等级
     * 表 : driver
     * 对应字段 : evaluate_grade
     */
    private Float evaluateGrade;

    /**
     * 身份证号
     * 表 : driver
     * 对应字段 : idcard
     */
    private String idcard;

    /**
     * 车牌号
     * 表 : driver
     * 对应字段 : license_number
     */
    private String licenseNumber;

    /**
     * 照片
     * 表 : driver
     * 对应字段 : photo
     */
    private String photo;

    /**
     * 身份证照片
     * 表 : driver
     * 对应字段 : idcard_photo
     */
    private String idcardPhoto;

    /**
     * 车牌照片
     * 表 : driver
     * 对应字段 : license_photo
     */
    private String licensePhoto;

    /**
     * 驾驶证照片
     * 表 : driver
     * 对应字段 : driver_license_photo
     */
    private String driverLicensePhoto;

    /**
     * 经度
     * 表 : driver
     * 对应字段 : longitude
     */
    private Double longitude;

    /**
     * 纬度
     * 表 : driver
     * 对应字段 : latitude
     */
    private Double latitude;

    /**
     * 创建时间
     * 表 : driver
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : driver
     * 对应字段 : update_time
     */
    private Date updateTime;

    private String authStateStr;

    /**
     *
     */
    public Driver(Integer id, String telephone, String password, String salt, String name, Integer status, Integer authState, Integer onlineState, Integer workState, Integer point, Float evaluateGrade, String idcard, String licenseNumber, String photo, String idcardPhoto, String licensePhoto, String driverLicensePhoto, Double longitude, Double latitude, Date createTime, Date updateTime) {
        this.id = id;
        this.telephone = telephone;
        this.password = password;
        this.salt = salt;
        this.name = name;
        this.status = status;
        this.authState = authState;
        this.onlineState = onlineState;
        this.workState = workState;
        this.point = point;
        this.evaluateGrade = evaluateGrade;
        this.idcard = idcard;
        this.licenseNumber = licenseNumber;
        this.photo = photo;
        this.idcardPhoto = idcardPhoto;
        this.licensePhoto = licensePhoto;
        this.driverLicensePhoto = driverLicensePhoto;
        this.longitude = longitude;
        this.latitude = latitude;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public Driver() {
        super();
    }

    /**
     * get method 
     *
     * @return driver.id：车主用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  车主用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return driver.telephone：手机号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * set method 
     *
     * @param telephone  手机号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * get method 
     *
     * @return driver.password：密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * set method 
     *
     * @param password  密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * get method 
     *
     * @return driver.salt：加密盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * set method 
     *
     * @param salt  加密盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * get method 
     *
     * @return driver.name：姓名
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return driver.status：账号状态（1：正常，2：冻结）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  账号状态（1：正常，2：冻结）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return driver.auth_state：认证状态（1：未认证，2：认证申请中，3：认证通过，4：认证失败）
     */
    public Integer getAuthState() {
        return authState;
    }

    /**
     * set method 
     *
     * @param authState  认证状态（1：未认证，2：认证申请中，3：认证通过，4：认证失败）
     */
    public void setAuthState(Integer authState) {
        this.authState = authState;
    }

    /**
     * get method 
     *
     * @return driver.online_state：在线状态（1：在线，2：不在线）
     */
    public Integer getOnlineState() {
        return onlineState;
    }

    /**
     * set method 
     *
     * @param onlineState  在线状态（1：在线，2：不在线）
     */
    public void setOnlineState(Integer onlineState) {
        this.onlineState = onlineState;
    }

    /**
     * get method 
     *
     * @return driver.work_state：接单状态（1：已接单，2：未接单）
     */
    public Integer getWorkState() {
        return workState;
    }

    /**
     * set method 
     *
     * @param workState  接单状态（1：已接单，2：未接单）
     */
    public void setWorkState(Integer workState) {
        this.workState = workState;
    }

    /**
     * get method 
     *
     * @return driver.point：积分
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * set method 
     *
     * @param point  积分
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * get method 
     *
     * @return driver.evaluate_grade：评价等级
     */
    public Float getEvaluateGrade() {
        return evaluateGrade;
    }

    /**
     * set method 
     *
     * @param evaluateGrade  评价等级
     */
    public void setEvaluateGrade(Float evaluateGrade) {
        this.evaluateGrade = evaluateGrade;
    }

    /**
     * get method 
     *
     * @return driver.idcard：身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * set method 
     *
     * @param idcard  身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * get method 
     *
     * @return driver.license_number：车牌号
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * set method 
     *
     * @param licenseNumber  车牌号
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
    }

    /**
     * get method 
     *
     * @return driver.photo：照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * set method 
     *
     * @param photo  照片
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * get method 
     *
     * @return driver.idcard_photo：身份证照片
     */
    public String getIdcardPhoto() {
        return idcardPhoto;
    }

    /**
     * set method 
     *
     * @param idcardPhoto  身份证照片
     */
    public void setIdcardPhoto(String idcardPhoto) {
        this.idcardPhoto = idcardPhoto == null ? null : idcardPhoto.trim();
    }

    /**
     * get method 
     *
     * @return driver.license_photo：车牌照片
     */
    public String getLicensePhoto() {
        return licensePhoto;
    }

    /**
     * set method 
     *
     * @param licensePhoto  车牌照片
     */
    public void setLicensePhoto(String licensePhoto) {
        this.licensePhoto = licensePhoto == null ? null : licensePhoto.trim();
    }

    /**
     * get method 
     *
     * @return driver.driver_license_photo：驾驶证照片
     */
    public String getDriverLicensePhoto() {
        return driverLicensePhoto;
    }

    /**
     * set method 
     *
     * @param driverLicensePhoto  驾驶证照片
     */
    public void setDriverLicensePhoto(String driverLicensePhoto) {
        this.driverLicensePhoto = driverLicensePhoto == null ? null : driverLicensePhoto.trim();
    }

    /**
     * get method 
     *
     * @return driver.create_time：创建时间
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
     * @return driver.update_time：更新时间
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAuthStateStr() {
        return authStateStr;
    }

    public void setAuthStateStr(String authStateStr) {
        this.authStateStr = authStateStr;

    }
}