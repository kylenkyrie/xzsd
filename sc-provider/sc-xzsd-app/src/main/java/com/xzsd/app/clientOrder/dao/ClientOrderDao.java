package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.EvaluateInfo;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientOrderDao {
    /**
     *查询商品信息
     * @param listGoodsId 商品id集合
     * @return
     */
    List<GoodsInfo> getGoodsInfo(@Param("listGoodsId") List<String> listGoodsId);

    /**
     *新增订单后更新商品信息
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

    /**
     * 查询订单列表
     * @param clientOrderInfo
     * @return
     */
    List<ClientOrderInfo> listOrder(ClientOrderInfo clientOrderInfo);

    /**
     * 修改订单状态
     * @param clientOrderInfo
     * @return
     */
    int updateOrderState(ClientOrderInfo clientOrderInfo);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    ClientOrderInfo listOrderDeepen(@Param("orderId") String orderId);

    /**
     *查询订单评价商品信息列表
     * @param orderId
     * @return
     */
    List<GoodsInfo> listGoodsForEvaluate(@Param("orderId") String orderId);

    /**
     * 新增订单商品评价接口
     * @param evaluateList
     * @return
     */
    int addGoodsEvaluate(@Param("evaluateList") List<EvaluateInfo> evaluateList);

    /**
     * 更新订单状态
     * @param orderId userId orderStateId
     * @return
     */
    int updateEvaluateOrder(@Param("orderId") String orderId,@Param("orderStateId") String orderStateId,
                            @Param("userId")String userId);

    /**
     * 更新商品评分
     * @param goodsId userId
     * @return
     */
    int updateEvaluateGoods(@Param("userId")String userId,@Param("goodsId") List<String> goodsId);

    /**
     * 修改商品库存
     * @param goodsList 商品信息集合
     * @return
     */
    int updateGoodsInventory (@Param("goodsList") List<GoodsInfo> goodsList);

    /**
     * 修改商品销量
     * @param goodsList 商品信息集合
     * @return
     */
    int updateGoodsSales (@Param("goodsList") List<GoodsInfo> goodsList);
}
