package com.xzsd.app.clientShopCart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientShopCart.dao.ClientShopCartDao;
import com.xzsd.app.clientShopCart.entity.ClientShopCartInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientShopCartService {
    @Resource
    private ClientShopCartDao clientShopCartDao;

    /**
     * 新增购物车
     * @param clientShopCartInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShoppingCart(ClientShopCartInfo clientShopCartInfo){
        //生成购物车id
        clientShopCartInfo.setShopCartId(StringUtil.getCommonCode(3));
        //查询库存
        int inventory = clientShopCartDao.getGoodsInventory(clientShopCartInfo.getGoodsId());
        clientShopCartInfo.setGoodsInventory(inventory);
        //判断当前商品购买数量是否超过商品库存
        if(clientShopCartInfo.getGoodsInventory() < Integer.valueOf(clientShopCartInfo.getCartGoodsCount())){
            return AppResponse.notFound("添加数量超过库存");
        }
        int count = clientShopCartDao.addShoppingCart(clientShopCartInfo);
        if(0 == count){
            return AppResponse.bizError("新增购物车失败");
        }
        return AppResponse.success("新增购物车成功");
    }

    /**
     * 查询购物车
     * @param clientShopCartInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-22
     */
    public AppResponse listShoppingCarts(ClientShopCartInfo clientShopCartInfo){
        PageHelper.startPage(clientShopCartInfo.getPageNum(), clientShopCartInfo.getPageSize());
        //查询购物车
        List<ClientShopCartInfo> listShoppingCart = clientShopCartDao.listShoppingCarts(clientShopCartInfo);
        PageInfo<ClientShopCartInfo> pageData = new PageInfo<ClientShopCartInfo>(listShoppingCart);
        return AppResponse.success("查询购物车列表成功", pageData);
    }

    /**
     * 修改购物车商品购买数量
     * @param clientShopCartInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShoppingCart(ClientShopCartInfo clientShopCartInfo){
        int count = clientShopCartDao.updateShoppingCart(clientShopCartInfo);
        if(0 == count){
            return AppResponse.bizError("修改购物车商品购买数量失败");
        }
        return AppResponse.success("修改购物车商品购买数量成功");
    }

    /**
     * 删除购物车
     * @param shopCartId
     * @return
     * @author yangmingzhen
     * @time 2020-4-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCart(String shopCartId, String userId){
        List<String> listCode = Arrays.asList(shopCartId.split(","));
        int count = clientShopCartDao.deleteShoppingCart(listCode, userId);
        if(0 == count){
            return AppResponse.bizError("删除购物车失败");
        }
        return AppResponse.success("删除购物车成功");
    }
}
