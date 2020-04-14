package com.xzsd.pc.order.entity;

import java.util.Date;

public class OrderInfo {

    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 订单代码
     */
    private String orderId;
    /**
     * 下单人id
     */
    private String orderCusId;
    /**
     * 下单人名称
     */
    private String orderCusName;
    /**
     * 订单总价
     */
    private String orderPrice;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 下单人手机号码
     */
    private String orderCusPhone;
    /**
     * 付款时间
     */
    private Date payTime;
    /**
     * 付款时间起
     */
    private Date payTimeStart;
    /**
     * 付款时间止
     */
    private Date payTimeEnd;
    /**
     * 角色
     */
    private int role;
    /**
     * 当前登录用户id
     */
    private String loginUserId;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCusId() {
        return orderCusId;
    }

    public void setOrderCusId(String orderCusId) {
        this.orderCusId = orderCusId;
    }

    public String getOrderCusName() {
        return orderCusName;
    }

    public void setOrderCusName(String orderCusName) {
        this.orderCusName = orderCusName;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getOrderCusPhone() {
        return orderCusPhone;
    }

    public void setOrderCusPhone(String orderCusPhone) {
        this.orderCusPhone = orderCusPhone;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(Date payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public Date getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(Date payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public int getRole() { return role; }

    public void setRole(int role) { this.role = role; }

    public String getLoginUserId() { return loginUserId; }

    public void setLoginUserId(String loginUserId) { this.loginUserId = loginUserId; }

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
