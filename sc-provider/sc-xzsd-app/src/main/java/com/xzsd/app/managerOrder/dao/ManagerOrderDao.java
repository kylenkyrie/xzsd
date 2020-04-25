package com.xzsd.app.managerOrder.dao;

import com.xzsd.app.managerOrder.entity.GoodsInfo;
import com.xzsd.app.managerOrder.entity.ManagerOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerOrderDao {
    /**
     * 查询订单列表
     * @param managerOrderInfo
     * @return
     */
    List<ManagerOrderInfo> listManagerOrders(ManagerOrderInfo managerOrderInfo);

    /**
     * 修改店长订单状态
     * @param managerOrderInfo
     * @return
     */
    int updateManagerOrderState(ManagerOrderInfo managerOrderInfo);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    ManagerOrderInfo listManagerOrderDeepen(@Param("orderId") String orderId);
}
