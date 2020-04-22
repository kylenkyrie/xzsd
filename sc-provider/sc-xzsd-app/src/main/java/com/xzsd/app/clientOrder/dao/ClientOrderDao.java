package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientOrderDao {
    /**
     *查询商品库存
     * @param listGoodsId 商品id集合
     * @return
     */
    List<GoodsInfo> getGoodsInfo(@Param("listGoodsId") List<String> listGoodsId);

    /**
     *更新商品库存,销售量,商品状态
     * @param goodsInfo
     * @return
     */
    int updateGoodsInfo(GoodsInfo goodsInfo);

    /**
     *新增订单表
     * @param clientOrderInfo
     * @return
     */
    int addOrder(ClientOrderInfo clientOrderInfo);

    /**
     * 增加数据到订单明细表
     * @param clientOrderInfoList
     * @return
     */
    int addOrderDetail(@Param("clientOrderInfoList") List<ClientOrderInfo> clientOrderInfoList);

    /**
     * 删除购物车
     * @param listCode
     * @param userId
     * @return
     */
    int deleteShoppingCart(@Param("listCode") List<String> listCode, @Param("userId") String userId);
//    /**
//     * 修改订单状态
//     * @param clientOrderInfo
//     * @return
//     */
//    int updateOrderState(ClientOrderInfo clientOrderInfo);
}
