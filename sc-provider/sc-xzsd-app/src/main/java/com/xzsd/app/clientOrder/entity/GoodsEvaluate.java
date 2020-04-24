package com.xzsd.app.clientOrder.entity;

import java.util.List;

public class GoodsEvaluate {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 评价信息
     */
    private List<EvaluateInfo> evaluateList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<EvaluateInfo> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<EvaluateInfo> evaluateList) {
        this.evaluateList = evaluateList;
    }
}
