package com.xzsd.pc.goods.entity;

import java.util.Date;

public class GoodsInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品状态
     */
    private int goodsStatus;
    /**
     * 广告词
     */
    private String goodsAdv;
    /**
     * 出版社
     */
    private String press;
    /**
     * 作者
     */
    private String author;
    /**
     * 一级分类
     */
    private String classOne;
    /**
     * 一级分类
     */
    private String classOneId;
    /**
     * 二级分类
     */
    private String classTwo;
    /**
     * 二级分类
     */
    private String classTwoId;
    /**
     * 浏览量
     */
    private int view;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 商品图片
     */
    private String goodsPicture;
    /**
     * 库存
     */
    private int inventory;
    /**
     * 成本价
     */
    private String costPrice;
    /**
     * 定价
     */
    private String price;
    /**
     * 售价
     */
    private String salesPrice;
    /**
     * 销量
     */
    private String goodsSales;
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
    /**
     * 商家名称
     */
    private String businessName;
    /**
     * 上架时间
     */
    private String shelfTime;
    /**
     * 商家编码
     */
    private String businessId;
    /**
     * 书号
     */
    private String bookId;

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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsAdv() {
        return goodsAdv;
    }

    public void setGoodsAdv(String goodsAdv) {
        this.goodsAdv = goodsAdv;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClassOne() {
        return classOne;
    }

    public void setClassOne(String classOne) {
        this.classOne = classOne;
    }

    public String getClassTwo() {
        return classTwo;
    }

    public String getClassOneId() { return classOneId; }

    public void setClassOneId(String classOneId) { this.classOneId = classOneId; }

    public String getClassTwoId() { return classTwoId; }

    public void setClassTwoId(String classTwoId) {
        this.classTwoId = classTwoId;
    }

    public int getView() { return view; }

    public void setView(int view) { this.view = view; }

    public void setClassTwo(String classTwo) {
        this.classTwo = classTwo;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(String goodsSales) {
        this.goodsSales = goodsSales;
    }

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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(String shelfTime) {
        this.shelfTime = shelfTime;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
