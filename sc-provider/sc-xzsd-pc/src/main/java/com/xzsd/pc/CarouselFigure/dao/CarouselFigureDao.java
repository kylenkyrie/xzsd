package com.xzsd.pc.CarouselFigure.dao;

import com.xzsd.pc.CarouselFigure.entity.CarouselFigureInfo;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarouselFigureDao {

    /**
     * 统计序号数量
     * @param carouselFigureInfo 轮播图信息
     * @return
     */
    int countSortId(CarouselFigureInfo carouselFigureInfo);

    /**
     * 新增轮播图片
     * @param carouselFigureInfo 图片信息
     * @return
     */
    int addPicture(CarouselFigureInfo carouselFigureInfo);

    /**
     * 获取所有轮播图信息
     * @param carouselFigureInfo 商品信息
     * @return 所有轮播图信息
     */
    List<CarouselFigureInfo> listPictureByPage(CarouselFigureInfo carouselFigureInfo);

    /**
     * 获取所有商品信息
     * @param goodsInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 修改轮播图状态
     * @param listUpdate
     * @return
     */
    int updatePictureStatus(@Param(value = "listUpdate") List<CarouselFigureInfo> listUpdate);

    /**
     * 删除轮播图信息
     * @param listCode 选中的轮播图编号集合
     * @param userCode 更新人
     * @return
     */
    int deletePicture(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);
}
