package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * demo 查询订单列表（分页）
     * @return
     * @author 杨明镇
     * @Date 2020-04-04
     */

    @RequestMapping(value = "listOrder")
    public AppResponse listOrder (OrderInfo orderInfo){
        try{
            return orderService.listOrder(orderInfo);

        }catch (Exception e){
            logger.error("查询订单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改商品状态
     * @param orderInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-03-28
     */
    @PostMapping("updateOrderStatus")
    public AppResponse updateUserStatus(OrderInfo orderInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setCreateBy(userId);
            orderInfo.setLastModifiedBy(userId);
            return orderService.updateOrderStatus(orderInfo);
        } catch (Exception e) {
            logger.error("修改订单状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询订单详情
     * @param orderId
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-04
     */

    @RequestMapping(value = "getOrderById")
    public AppResponse getOrderById(String orderId) {
        try {
            return orderService.getOrderById(orderId);
        } catch (Exception e) {
            logger.error("订单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
