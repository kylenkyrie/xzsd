package com.xzsd.app.clientOrder.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.GsonBuilder;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodsEvaluate;
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
        //检验用户是否已经绑定店铺邀请码
        String store = clientOrderInfo.getStoreId();
        if(store == ""){
            return AppResponse.versionError("用户未绑定店铺邀请码");
        }
        //生成订单表Id
        clientOrderInfo.setOrderId(StringUtil.getCommonCode(2));
        //存放商品编号
        List<String> listGoodsId = Arrays.asList(clientOrderInfo.getGoodsId().split(","));
        //存放商品价格
        List<String> listGoodsPrice = Arrays.asList(clientOrderInfo.getGoodsPrice().split(","));
        //存放商品数量
        List<String> listGoodsCount = Arrays.asList(clientOrderInfo.getClientGoodsNum().split(","));
        //获取id对应的商品信息
        List<GoodsInfo> listGoodsInfo = clientOrderDao.getGoodsInfo(listGoodsId);
        //订单明细表list
        List<ClientOrderInfo> clientOrderInfoList = new ArrayList<>();
        //订单商品总数量
        int allGoodsCnt = 0;
        int theGoodsAllPrice = 0;
        //计算商品总价和购买数量
        for (int i = 0; i < listGoodsId.size() ; i++) {
            //判断当前商品购买数量是否超过商品库存
            if(listGoodsInfo.get(i).getGoodsInventory() < Integer.valueOf(listGoodsCount.get(i))){
                return AppResponse.versionError("购买数量超过库存");
            }
            //购买后的库存
            listGoodsInfo.get(i).setGoodsInventory(listGoodsInfo.get(i).getGoodsInventory() - Integer.valueOf(listGoodsCount.get(i)));
            //库存为0时,商品状态为下架
            if(listGoodsInfo.get(i).getGoodsInventory() == 0){
                listGoodsInfo.get(i).setGoodsStateId(2);
            }
            //更新商品库存,商品状态
            int update = clientOrderDao.updateGoodsInfo(listGoodsInfo.get(i));
            if(0 == update){
                return AppResponse.versionError("商品信息修改失败,请重试");
            }
            //计算商品总数量
            allGoodsCnt = allGoodsCnt + Integer.valueOf(listGoodsCount.get(i));
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
        //设置订单总数
        clientOrderInfo.setOrderAllGoodsCount(allGoodsCnt);
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
                    return AppResponse.notFound("新增订单失败");
                }
            }
                return AppResponse.success("新增订单成功");
        }
        return AppResponse.notFound("新增订单失败");
    }

    /**
     *查询订单列表
     * @param clientOrderInfo
     * @return
     * @author yangmingzhen
     * @time 2020-4-23
     */
    public AppResponse listOrder(ClientOrderInfo clientOrderInfo){
        PageHelper.startPage(clientOrderInfo.getPageNum(), clientOrderInfo.getPageSize());
        //查询订单列表
        List<ClientOrderInfo> orderList = clientOrderDao.listOrder(clientOrderInfo);
        PageInfo<ClientOrderInfo> pageData = new PageInfo<>(orderList);
        return AppResponse.success("查询订单列表成功",pageData);
    }

    /**
     *修改订单状态
     * @param clientOrderInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(ClientOrderInfo clientOrderInfo){
        int count = clientOrderDao.updateOrderState(clientOrderInfo);
        if(0 == count){
            return AppResponse.bizError("修改订单状态失败");
        }
        //订单取消时增加库存/订单完成时增加销量
        if (clientOrderInfo.getOrderStateId().equals("1")){
            //调用订单详情获取对应的商品lIST
            clientOrderInfo = clientOrderDao.listOrderDeepen(clientOrderInfo.getOrderId());
            List<GoodsInfo> goodsList =  clientOrderInfo.getGoodsList();
            //修改库存
            int countGoods = clientOrderDao.updateGoodsInventory(goodsList);
            if(countGoods == 0){
                return AppResponse.bizError("修改商品库存失败");
            }
        }
        if (clientOrderInfo.getOrderStateId().equals("4")){
            //调用订单详情获取对应的商品lIST
            clientOrderInfo = clientOrderDao.listOrderDeepen(clientOrderInfo.getOrderId());
            List<GoodsInfo> goodsList =  clientOrderInfo.getGoodsList();
            //修改销量
            int countGoods = clientOrderDao.updateGoodsSales(goodsList);
            if(countGoods == 0){
                return AppResponse.bizError("修改商品销量失败");
            }
        }
        return AppResponse.success("修改订单状态成功");
    }

    /**
     *查询订单详情
     * @param orderId
     * @return
     * @author yangmingzhen
     * @time 2020-4-23
     */
    public AppResponse listOrderDeepen(String orderId) {
        ClientOrderInfo clientOrderInfo = clientOrderDao.listOrderDeepen(orderId);
        //地址拼接
        if (clientOrderInfo.getAreaName() != null){
            clientOrderInfo.setAddress(clientOrderInfo.getProvinceName() + clientOrderInfo.getCityName() + clientOrderInfo.getAreaName() + clientOrderInfo.getAddress());
        }
        else{
            clientOrderInfo.setAddress(clientOrderInfo.getProvinceName() + clientOrderInfo.getCityName() + clientOrderInfo.getAddress());
        }
        return AppResponse.success("查询订单详情成功！", clientOrderInfo);
    }

    /**
     *查询订单评价商品信息列表
     * @param orderId
     * @return
     * @author yangmingzhen
     * @time 2020-04-23
     */
    public AppResponse listGoodsForEvaluate(String orderId){
        List<GoodsInfo> goodsList = clientOrderDao.listGoodsForEvaluate(orderId);
        if(goodsList.size() == 0){
            return AppResponse.bizError("查询订单评价列表失败");
        }
        return AppResponse.success("查询订单评价列表成功", goodsList);
    }

    /**
     *查询订单评价商品信息列表
     * @param goodsEvaluate userId
     * @return
     * @author yangmingzhen
     * @time 2020-04-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsEvaluate(JSONObject goodsEvaluate,String userId){
        //将json数据转换成实体类
        GoodsEvaluate goodsEva = goodsEvaluate.toJavaObject(GoodsEvaluate.class);
        //初始化商品编号集合（用于修改商品评分信息）
        List<String> goodsId = new ArrayList<>();
        for (int i = 0 ; i < goodsEva.getEvaluateList().size() ; i++){
            //生成评价的编号
            goodsEva.getEvaluateList().get(i).setEvaluateId(StringUtil.getCommonCode(2));
            //设置评价用户编号
            goodsEva.getEvaluateList().get(i).setUserId(userId);
            goodsId.add(goodsEva.getEvaluateList().get(i).getGoodsId());
        }
        System.out.println(goodsId);
        //新增商品评价
        int count = clientOrderDao.addGoodsEvaluate(goodsEva.getEvaluateList());
        if ( count == 0 ){
            return AppResponse.versionError("新增商品评价失败！");
        }
        //修改订单状态和商品评价评分
        int countOrder = clientOrderDao.updateEvaluateOrder(goodsEva.getOrderId(),"5",userId);
        int countGoods = clientOrderDao.updateEvaluateGoods(userId,goodsId);
        if (countOrder == 0){
            return AppResponse.versionError("订单状态更新失败！");
        }
        if (countGoods == 0){
            return AppResponse.versionError("商品评分更新失败！");
        }
        return AppResponse.success("新增商品评价成功！");
    }
}
