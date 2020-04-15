package com.xzsd.pc.hotgoods.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hotgoods")
public class HotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;

    /**
     * demo 新增
     * @param hotGoodsInfo
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-08
     */
    @PostMapping("addHotGoods")
    public AppResponse addGoods(HotGoodsInfo hotGoodsInfo){
        try{

            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreateBy(userId);
            AppResponse appResponse = hotGoodsService.addHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("热门商品新增失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * 功能：获取热门商品列表
     * 作者：yangmingzhen
     * 时间：2020—04—08
     */
//    @SystemLog1(operation = "获取用户列表。。。。。")
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            return hotGoodsService.listHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("热门商品列表查询异常", e);
            throw new ScServerException("查询错误，请重试");
        }
    }


    /**
     * demo 查询商品列表（分页）
     * @return
     * @author 杨明镇
     * @Date 2020-03-30
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods (GoodsInfo goodsInfo){
        try{
            return hotGoodsService.listGoods(goodsInfo);

        }catch (Exception e){
            logger.error("查询商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改热门商品
     * @param hotGoodsInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-03-30
     */
    @PostMapping("updateGoods")
    public AppResponse updateUser(HotGoodsInfo hotGoodsInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreateBy(userId);
            hotGoodsInfo.setLastModifiedBy(userId);
            return hotGoodsService.updateGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("修改热门商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 展示数设置
     * @return 展示的热门商品信息
     * @author 杨明镇
     * @Date 2020-04-08
     */
    @RequestMapping(value = "updateShowCnt")
    public AppResponse updateShowCnt (HotGoodsInfo hotGoodsInfo){
        try{
            return hotGoodsService.updateShowCnt(hotGoodsInfo);

        }catch (Exception e){
            logger.error("查询热门商品异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
