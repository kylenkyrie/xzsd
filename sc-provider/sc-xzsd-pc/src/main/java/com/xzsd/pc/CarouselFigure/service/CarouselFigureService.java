package com.xzsd.pc.CarouselFigure.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.CarouselFigure.dao.CarouselFigureDao;
import com.xzsd.pc.CarouselFigure.entity.CarouselFigureInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 轮播图实现类
 * @Author yangmingzhen
 * @Date 2020-03-30
 */
@Service
public class CarouselFigureService {
    @Resource
    private CarouselFigureDao carouselFigureDao;


    /**
     * demo 新增轮播图片
     * @param carouselFigureInfo 轮播图信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addPicture(CarouselFigureInfo carouselFigureInfo){
        // 校验序号是否存在
        int countSortId = carouselFigureDao.countSortId(carouselFigureInfo);
        if(0 != countSortId) {
            return AppResponse.bizError("该序号已有图片存在，请重新输入！");
        }
        carouselFigureInfo.setPictureId(StringUtil.getCommonCode(3));
        carouselFigureInfo.setIsDeleted(0);
        //新增轮播图片
        int count = carouselFigureDao.addPicture(carouselFigureInfo);
        if(count == 0){
            return AppResponse.bizError("新增轮播图失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 所有轮播图信息
     * @param carouselFigureInfo 轮播图信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-30
     */
    public AppResponse listPicture(CarouselFigureInfo carouselFigureInfo){
        PageHelper.startPage(carouselFigureInfo.getPageNum(),carouselFigureInfo.getPageSize());
        List<CarouselFigureInfo> carouselFigureInfoList = carouselFigureDao.listPictureByPage(carouselFigureInfo);
        //包装对象g
        PageInfo<CarouselFigureInfo> pageData = new PageInfo<CarouselFigureInfo>(carouselFigureInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 新增轮播图中所有在售商品信息
     * @param goodsInfo 在售商品信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-27
     */
    public AppResponse listGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(),goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = carouselFigureDao.listGoodsByPage(goodsInfo);
        //包装对象g
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodsInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 修改轮播图状态
     * @param carouselFigureInfo
     * @Author yangmingzhen
     * @Date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePictureStatus(CarouselFigureInfo carouselFigureInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改轮播图状态
        int count = carouselFigureDao.updatePictureStatus(carouselFigureInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除轮播图
     * @param pictureId
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deletePicture(String pictureId,String userCode){
        List<String> listCode = Arrays.asList(pictureId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除轮播图
        int count = carouselFigureDao.deletePicture(listCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}

