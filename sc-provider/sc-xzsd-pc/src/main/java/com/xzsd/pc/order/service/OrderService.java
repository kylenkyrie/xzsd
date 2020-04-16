package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetail;
import com.xzsd.pc.order.entity.OrderInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @DescriptionDemo 实现类
 * @Author yangmingzhen
 * @Date 2020-04-05
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    /**
     * demo 查询订单列表（分页）
     * @param orderInfo 订单信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-04
     */
    public AppResponse listOrder(OrderInfo orderInfo) {
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderInfo> orderInfoList = orderDao.listOrderByPage(orderInfo);
        // 包装Page对象
        PageInfo<OrderInfo> pageData = new PageInfo<OrderInfo>(orderInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 修改订单状态
     * @param orderInfo 订单信息
     * @Author yangmingzhen
     * @Date 2020-04-04
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderInfo orderInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改订单状态
        int count = orderDao.updateOrderStatus(orderInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询订单详情
     * @param orderId 订单信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-04
     */
    public AppResponse getOrderById(String orderId) {
        OrderDetail orderInfo = orderDao.getOrderById(orderId);
        return AppResponse.success("查询成功！",orderInfo);
    }
}
