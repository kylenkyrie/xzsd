package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotGoodsDao {

    /**
     * 统计序号数量
     * @param hotGoodsInfo 热门商品信息
     * @return
     */
    int countSortId(HotGoodsInfo hotGoodsInfo);

    /**
     * 新增热门商品
     * @param hotGoodsInfo 分类信息
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 获取所有热门商品信息
     * @param hotGoodsInfo 热门商品信息
     * @return 所有热门商品信息
     */
    List<HotGoodsInfo> listHotGoodsByPage(HotGoodsInfo hotGoodsInfo);

    /**
     * 获取所有商品信息
     * @param goodsInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 修改热门商品信息
     * @param hotgoodsInfo 热门商品信息
     * @return 修改结果
     */
    int updateHotGoods(HotGoodsInfo hotgoodsInfo);

    /**
     * 展示数量设置
     * @param hotgoodsInfo 热门商品信息
     * @return 修改结果
     */
    int updateShowCnt(HotGoodsInfo hotgoodsInfo);
}
