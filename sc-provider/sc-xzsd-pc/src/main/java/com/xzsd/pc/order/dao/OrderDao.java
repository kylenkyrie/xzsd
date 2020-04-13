package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetail;
import com.xzsd.pc.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @ClassName OrderDao
 * @Description Order
 * @Author yangmingzhen
 * @Date 2020-04-05
 */
@Mapper
public interface OrderDao {

    /**
     * 获取所有订单信息
     * @param orderInfo 订单信息
     * @return 所有订单信息
     */
    List<OrderInfo> listOrderByPage(OrderInfo orderInfo);

    /**
     * 修改商品状态
     * @param orderInfo 商品信息
     * @return 修改结果
     */
    int updateOrderStatus(OrderInfo orderInfo);

    /**
     * 查询订单详情
     * @param orderId 订单id
     * @return 修改结果
     */
    OrderDetail getOrderById(@Param("orderId") String orderId);
}
