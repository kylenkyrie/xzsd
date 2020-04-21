package com.xzsd.app.clientGoods.entity;

import java.util.Date;

/**
 * 商品实体类
 */
public class GoodsInfo {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 书号
     */
    private String isbn;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 一级分类名称
     */
    private String oneClassifyName;
    /**
     * 二级分类名称
     */
    private String twoClassifyName;
    /**
     * 一级分类id
     */
    private String oneClassifyId;
    /**
     * 二级分类id
     */
    private String twoClassifyId;
    /**
     * 广告词
     */
    private String goodsAdvertise;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 进货商家名称
     */
    private String supplierName;
    /**
     * 库存
     */
    private int goodsInventory;
    /**
     * 成本价
     */
    private double goodsOriginalCost;
    /**
     * 售价
     */
    private double goodsPrice;
    /**
     * 销售量
     */
    private int goodsSales;
    /**
     * 商品状态编号：1在售、2已下架、3未发布
     */
    private int goodsStateId;
    /**
     * 上架时间
     */
    private String goodsShelfTime;
    /**
     * 商品图片路径
     */
    private String goodsImagePath;
    /**
     * 浏览量
     */
    private int goodsViewsNum;
    /**
     * 作者
     */
    private String goodsAuthor;
    /**
     * 出版社
     */
    private String goodsPress;
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
     *平均评价等级
     */
    private double goodsEvaluateScore;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getOneClassifyName() {
        return oneClassifyName;
    }

    public void setOneClassifyName(String oneClassifyName) {
        this.oneClassifyName = oneClassifyName;
    }

    public String getTwoClassifyName() {
        return twoClassifyName;
    }

    public void setTwoClassifyName(String twoClassifyName) {
        this.twoClassifyName = twoClassifyName;
    }

    public String getOneClassifyId() {
        return oneClassifyId;
    }

    public void setOneClassifyId(String oneClassifyId) {
        this.oneClassifyId = oneClassifyId;
    }

    public String getTwoClassifyId() {
        return twoClassifyId;
    }

    public void setTwoClassifyId(String twoClassifyId) {
        this.twoClassifyId = twoClassifyId;
    }

    public String getGoodsAdvertise() {
        return goodsAdvertise;
    }

    public void setGoodsAdvertise(String goodsAdvertise) {
        this.goodsAdvertise = goodsAdvertise;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public double getGoodsOriginalCost() {
        return goodsOriginalCost;
    }

    public void setGoodsOriginalCost(double goodsOriginalCost) {
        this.goodsOriginalCost = goodsOriginalCost;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(int goodsSales) {
        this.goodsSales = goodsSales;
    }

    public int getGoodsStateId() {
        return goodsStateId;
    }

    public void setGoodsStateId(int goodsStateId) {
        this.goodsStateId = goodsStateId;
    }

    public String getGoodsShelfTime() {
        return goodsShelfTime;
    }

    public void setGoodsShelfTime(String goodsShelfTime) {
        this.goodsShelfTime = goodsShelfTime;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public int getGoodsViewsNum() {
        return goodsViewsNum;
    }

    public void setGoodsViewsNum(int goodsViewsNum) {
        this.goodsViewsNum = goodsViewsNum;
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
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

    public double getGoodsEvaluateScore() {
        return goodsEvaluateScore;
    }

    public void setGoodsEvaluateScore(double goodsEvaluateScore) {
        this.goodsEvaluateScore = goodsEvaluateScore;
    }
}
