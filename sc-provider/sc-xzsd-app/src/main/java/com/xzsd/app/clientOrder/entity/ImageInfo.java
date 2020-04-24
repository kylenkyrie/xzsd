package com.xzsd.app.clientOrder.entity;

public class ImageInfo {
    /**
     * 图片编号
     */
    private String imageId;
    /**
     * 商品评价编号
     */
    private String evaluateId;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 图片顺序
     */
    private String imageNum;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getImageNum() {
        return imageNum;
    }

    public void setImageNum(String imageNum) {
        this.imageNum = imageNum;
    }
}
