package com.xzsd.app.managerOrder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.managerOrder.dao.ManagerOrderDao;
import com.xzsd.app.managerOrder.entity.GoodsInfo;
import com.xzsd.app.managerOrder.entity.ManagerOrderInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerOrderService {

    @Resource
    private ManagerOrderDao managerOrderDao;

    /**
     *查询店长订单列表
     * @param managerOrderInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-24
     */
    public AppResponse listOrder(ManagerOrderInfo managerOrderInfo){
        PageHelper.startPage(managerOrderInfo.getPageNum(), managerOrderInfo.getPageSize());
        //查询订单列表
        List<ManagerOrderInfo> orderList = managerOrderDao.listManagerOrders(managerOrderInfo);
        PageInfo<ManagerOrderInfo> pageData = new PageInfo<>(orderList);
        return AppResponse.success("查询订单列表成功",pageData);
    }

    /**
     * 修改店长订单状态
     * @param managerOrderInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateManagerOrderState(ManagerOrderInfo managerOrderInfo){
        int count = managerOrderDao.updateManagerOrderState(managerOrderInfo);
        if(count == 0){
            return AppResponse.notFound("修改订单状态失败");
        }
        //订单取消时增加库存
        if (managerOrderInfo.getOrderStateId().equals("1")){
            //调用订单详情获取对应的商品lIST
            managerOrderInfo = managerOrderDao.listManagerOrderDeepen(managerOrderInfo.getOrderId());
            List<GoodsInfo> goodsList =  managerOrderInfo.getGoodsList();
            //修改库存
            int countGoods = managerOrderDao.updateGoodsInventory(goodsList);
            if(countGoods == 0){
                return AppResponse.bizError("修改商品库存失败");
            }
        }
        return AppResponse.success("修改订单状态成功");
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @author yangmingzhen
     * @time 2020-04-25
     */
    public AppResponse listManagerOrderDeepen(String orderId){
        ManagerOrderInfo managerOrderInfo = managerOrderDao.listManagerOrderDeepen(orderId);
        //地址拼接
        if (managerOrderInfo.getAreaName() != null){
            managerOrderInfo.setAddress(managerOrderInfo.getProvinceName() + managerOrderInfo.getCityName() + managerOrderInfo.getAreaName() + managerOrderInfo.getAddress());
        }
        else{
            managerOrderInfo.setAddress(managerOrderInfo.getProvinceName() + managerOrderInfo.getCityName() + managerOrderInfo.getAddress());
        }
        return AppResponse.success("查询订单详情成功！",managerOrderInfo);
    }
}
