package com.xzsd.pc.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import com.xzsd.pc.goodsClassification.entity.ClassInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * demo 新增商品
     * @param goodsInfo
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-27
     */
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodsInfo goodsInfo){
        try{
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userId);
            AppResponse appResponse = goodsService.addGoods(goodsInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("商品新增失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * demo 查询商品列表（分页）
     * @return
     * @author 杨明镇
     * @Date 2020-03-27
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods (GoodsInfo goodsInfo){
        try{
            return goodsService.listGoods(goodsInfo);

        }catch (Exception e){
            logger.error("查询商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改商品
     * @param goodsInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-03-28
     */
    @PostMapping("updateGoods")
    public AppResponse updateUser(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userId);
            goodsInfo.setLastModifiedBy(userId);
            return goodsService.updateGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询商品详情
     * @param goodsId
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-28
     */
    @RequestMapping(value = "getGoodsByGoodsId")
    public AppResponse getGoodsByGoodsId(String goodsId) {
        try {
            return goodsService.getGoodsByGoodsId(goodsId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除商品信息
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-28
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsId){
        try{
            //获取登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsId,userId);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改商品状态
     * @param goodsInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-03-28
     */
    @PostMapping("updateGoodsStatus")
    public AppResponse updateUserStatus(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userId);
            goodsInfo.setLastModifiedBy(userId);
            return goodsService.updateGoodsStatus(goodsInfo);
        } catch (Exception e) {
            logger.error("修改商品状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询商品分类详情
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-28
     */
    @RequestMapping(value = "listClass")
    public AppResponse listClass(ClassInfo classInfo) {
        try {
            return goodsService.listClass(classInfo);
        } catch (Exception e) {
            logger.error("商品分类查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
