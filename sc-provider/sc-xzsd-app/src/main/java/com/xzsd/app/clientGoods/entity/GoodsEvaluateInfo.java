package com.xzsd.app.clientGoods.entity;

import java.util.List;

/**
 * 商品评价表
 */
public class GoodsEvaluateInfo {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 评价用户账号
     */
    private String userAcct;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价等级
     */
    private int evaluateScore;
    /**
     * 评价时间
     */
    private String createTime;
    /**
     * 一页多少条
     */
    private int pageSize;
    /**
     * 第几页
     */
    private int pageNum;
    /**
     * 子节点
     */
    private List<GoodsEvaluateInfo> imageList;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 评价图片路径
     */
    private String imagePath;
    /**
     * 评价图片id
     */
    private String imageId;
    /**
     *评价编号
     */
    private String evaluateId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public List<GoodsEvaluateInfo> getImageList() {
        return imageList;
    }

    public void setImageList(List<GoodsEvaluateInfo> imageList) {
        this.imageList = imageList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }
}
