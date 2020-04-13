package com.xzsd.pc.CarouselFigure.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.CarouselFigure.entity.CarouselFigureInfo;
import com.xzsd.pc.CarouselFigure.service.CarouselFigureService;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查Carousel figure
 * @Author yangmingzhen
 * @Date 2020-03-30
 */
@RestController
@RequestMapping("/CarouselFigure")
public class CarouselFigureController {
    private static final Logger logger = LoggerFactory.getLogger(CarouselFigureController.class);

    @Resource
    private CarouselFigureService carouselFigureService;

    /**
     * demo 新增
     * @param carouselFigureInfo
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-30
     */
    @PostMapping("addPicture")
    public AppResponse addPicture(CarouselFigureInfo carouselFigureInfo){
        try{
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            carouselFigureInfo.setCreateBy(userId);
            AppResponse appResponse = carouselFigureService.addPicture(carouselFigureInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("图片新增失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * demo 查询轮播图列表（分页）
     * @return
     * @author 杨明镇
     * @Date 2020-03-30
     */
    @RequestMapping(value = "listPicture")
    public AppResponse listPcicture (CarouselFigureInfo carouselFigureInfo){
        try{
            return carouselFigureService.listPicture(carouselFigureInfo);

        }catch (Exception e){
            logger.error("查询轮播图列表异常",e);
            System.out.println(e.toString());
            throw e;
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
            return carouselFigureService.listGoods(goodsInfo);

        }catch (Exception e){
            logger.error("查询商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * demo 修改商品状态
     * @param carouselFigureInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-03-30
     */
    @PostMapping("updatePictureStatus")
    public AppResponse updatePictureStatus(CarouselFigureInfo carouselFigureInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            carouselFigureInfo.setCreateBy(userId);
            carouselFigureInfo.setLastModifiedBy(userId);
            return carouselFigureService.updatePictureStatus(carouselFigureInfo);
        } catch (Exception e) {
            logger.error("修改轮播图状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除轮播图信息
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-30
     */
    @PostMapping("deletePicture")
    public AppResponse deletePicture(String pictureId){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            return carouselFigureService.deletePicture(pictureId,userId);
        } catch (Exception e) {
            logger.error("轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
