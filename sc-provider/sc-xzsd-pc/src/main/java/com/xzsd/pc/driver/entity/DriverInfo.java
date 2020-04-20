package com.xzsd.pc.driver.entity;

import java.util.Date;

public class DriverInfo {
    /**
     * 司机编号
     */
    private String driverId;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 司机账号
     */
    private String driverAcct;
    /**
     * 司机密码
     */
    private String driverPwd;
    /**
     * 司机身份证号码
     */
    private String idCard;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 所在省
     */
    private String province;
    /**
     * 所在市
     */
    private String city;
    /**
     * 所在区
     */
    private String area;
    /**
     * 所在省
     */
    private String provinceId;
    /**
     * 所在市
     */
    private String cityId;
    /**
     * 所在区
     */
    private String areaId;
    /**
     * 司机头像
     */
    private String imagePath;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private String version;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAcct() {
        return driverAcct;
    }

    public void setDriverAcct(String driverAcct) {
        this.driverAcct = driverAcct;
    }

    public String getDriverPwd() {
        return driverPwd;
    }

    public void setDriverPwd(String driverPwd) {
        this.driverPwd = driverPwd;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvinceId() { return provinceId; }

    public void setProvinceId(String provinceId) { this.provinceId = provinceId; }

    public String getCityId() { return cityId; }

    public void setCityId(String cityId) { this.cityId = cityId; }

    public String getAreaId() { return areaId; }

    public void setAreaId(String areaId) { this.areaId = areaId; }

    public String getImagePath() { return imagePath; }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
