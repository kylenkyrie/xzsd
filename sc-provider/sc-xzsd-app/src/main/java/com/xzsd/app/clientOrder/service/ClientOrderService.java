package com.xzsd.app.clientOrder.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientOrderService {
    @Resource
    private ClientOrderDao clientOrderDao;

    /**
     *新增订单
     * @param clientOrderInfo
     * @return
     * @author yangmingzhen
     * @time 2020-4-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo){
        //生成订单表Id
        clientOrderInfo.setOrderId(StringUtil.getCommonCode(2));
        //分割商品编号
        List<String> listGoodsId = Arrays.asList(clientOrderInfo.getGoodsId().split(","));
        //分割商品价格
        List<String> listGoodsPrice = Arrays.asList(clientOrderInfo.getGoodsPrice().split(","));
        //分割商品数量
        List<String> listGoodsCount = Arrays.asList(clientOrderInfo.getClientGoodsNum().split(","));
        //获取商品信息
        List<GoodsInfo> listGoodsInfo = clientOrderDao.getGoodsInfo(listGoodsId);
        //订单明细表list
        List<ClientOrderInfo> clientOrderInfoList = new ArrayList<>();
        //商品总价格
        int theGoodsAllPrice = 0;
        //计算商品总价和购买数量
        for (int i = 0; i < listGoodsId.size() ; i++) {
            //赋值购买后的库存
            listGoodsInfo.get(i).setGoodsInventory(listGoodsInfo.get(i).getGoodsInventory() - Integer.valueOf(listGoodsCount.get(i)));
            //库存为0时,赋值商品状态为下架
            if(listGoodsInfo.get(i).getGoodsInventory() == 0){
                listGoodsInfo.get(i).setGoodsStateId(2);
            }
            //赋值销量
            listGoodsInfo.get(i).setGoodsSales(listGoodsInfo.get(i).getGoodsSales()+Integer.valueOf(listGoodsCount.get(i)));
            //更新商品库存,销售量,商品状态
            int update = clientOrderDao.updateGoodsInfo(listGoodsInfo.get(i));
            if(0 == update){
                return AppResponse.versionError("商品信息修改失败,请重试");
            }
            //总价格
            theGoodsAllPrice = theGoodsAllPrice + Integer.valueOf(listGoodsPrice.get(i)) * Integer.valueOf(listGoodsCount.get(i));
            //初始化设置订单明细表数据
            ClientOrderInfo orderInfo = new ClientOrderInfo();
            //订单明细的订单id赋值
            orderInfo.setOrderId(clientOrderInfo.getOrderId());
            //生成订单明细表Id
            orderInfo.setOrderDetailId(StringUtil.getCommonCode(2));
            //订单明细商品id赋值
            orderInfo.setGoodsId(listGoodsId.get(i));
            //订单明细用户id赋值
            orderInfo.setUserId(clientOrderInfo.getUserId());
            //订单明细商品数量赋值
            orderInfo.setClientGoodsNum(listGoodsCount.get(i));
            //计算订单总价
            int totalPrice = Integer.valueOf(listGoodsPrice.get(i)) * Integer.valueOf(listGoodsCount.get(i));
            //订单明细总价赋值
            orderInfo.setTheGoodsAllPrice(String.valueOf(totalPrice));
            clientOrderInfoList.add(orderInfo);
        }
        //设置订单总价
        clientOrderInfo.setOrderAllCost(String.valueOf(theGoodsAllPrice));
        //增加数据到订单表
        int count = clientOrderDao.addOrder(clientOrderInfo);
        //增加数据到订单明细表
        int counts = clientOrderDao.addOrderDetail(clientOrderInfoList);
        //判断是否为购物车结算，并删除对应购物车
        if(0 != count && 0 != counts){
            if (clientOrderInfo.getShopCartId()!= "") {
                //分割购物车编号
                List<String> listShopCart = Arrays.asList(clientOrderInfo.getShopCartId().split(","));
                //删除购物车对应商品
                int countShopCart = clientOrderDao.deleteShoppingCart(listShopCart, clientOrderInfo.getUserId());
                if (0 == countShopCart) {
                    return AppResponse.bizError("新增订单失败");
                }
            }
                return AppResponse.success("新增订单成功");
        }
        return AppResponse.bizError("新增订单失败");
    }
}
