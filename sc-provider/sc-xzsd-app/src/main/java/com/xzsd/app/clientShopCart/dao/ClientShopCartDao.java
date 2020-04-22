package com.xzsd.app.clientShopCart.dao;

import com.xzsd.app.clientShopCart.entity.ClientShopCartInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientShopCartDao {
    /**
     * 新增购物车
     * @param clientShopCartInfo
     * @return
     */
    int addShoppingCart(ClientShopCartInfo clientShopCartInfo);

    /**
     * 查询购物车列表
     * @param clientShopCartInfo
     * @return
     */
    List<ClientShopCartInfo> listShoppingCarts(ClientShopCartInfo clientShopCartInfo);

    /**
     * 修改购物车商品购买数量
     * @param clientShopCartInfo
     * @return
     */
    int updateShoppingCart(ClientShopCartInfo clientShopCartInfo);

    /**
     * 删除购物车
     * @param listCode
     * @param userId
     * @return
     */
    int deleteShoppingCart(@Param("listCode") List<String> listCode, @Param("userId") String userId);
}
