package com.xzsd.app.managerOrder.entity;

import java.util.List;

public class ManagerOrderInfo {
    /**
     * 一页多少条
     */
    private int pageSize;
    /**
     * 第几页
     */
    private int pageNum;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 订单详情id
     */
    private String orderDetailsId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品价格
     */
    private String salesPrice;
    /**
     * 单个商品购买数量
     */
    private String goodsCount;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 订单总价
     */
    private String totalGoodsPrice;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 总购买数
     */
    private int orderAllGoodsCount;
    /**
     * 版本号
     */
    private String version;
    /**
     * 创建时间
     */
    private String crateTime;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 门店id
     */
    private String storeId;
    /**
     * 客户名称
     */
    private String userName;
    /**
     * 客户电话
     */
    private String phone;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店地址
     */
    private String address;
    /**
     * 省名
     */
    private String provinceName;
    /**
     * 市名
     */
    private String cityName;
    /**
     * 区名
     */
    private String areaName;
    /**
     * 店长编号
     */
    private String managerId;
    /**
     * 图片路径
     */
    private String goodsImagePath;
    /**
     * 商品描述
     */
    private String goodsDescribe;
    /**
     * 商品库存
     */
    private String goodsInventory;
    /**
     * 商品列表
     */
    private List<GoodsInfo> goodsList;
    /**
     * 创建时间
     */
    private String gmtCreate;

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public List<GoodsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

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

    public String getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(String orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(String goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(String goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public String getTotalGoodsPrice() {
        return totalGoodsPrice;
    }

    public void setTotalGoodsPrice(String totalGoodsPrice) {
        this.totalGoodsPrice = totalGoodsPrice;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public int getOrderAllGoodsCount() {
        return orderAllGoodsCount;
    }

    public void setOrderAllGoodsCount(int orderAllGoodsCount) {
        this.orderAllGoodsCount = orderAllGoodsCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(String crateTime) {
        this.crateTime = crateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
