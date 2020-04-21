package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.ShowCntInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    List<HotGoodsInfo> listHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 获取所有商品信息
     * @param goodsInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 查询热门位商品详情
     * @param hotGoodsId 热门位商品id
     * @return 修改结果
     */
    HotGoodsInfo getHotGoods(@Param("hotGoodsId") String hotGoodsId);

    /**
     * 修改热门商品信息
     * @param hotgoodsInfo 热门商品信息
     * @return 修改结果
     */
    int updateHotGoods(HotGoodsInfo hotgoodsInfo);

    /**
     * 查询热门位商品展示数量
     * @return 修改结果
     */
    ShowCntInfo getShowCnt();

    /**
     * 展示数量设置
     * @param hotgoodsInfo 热门商品信息
     * @return 修改结果
     */
    int updateShowCnt(HotGoodsInfo hotgoodsInfo);

    /**
     * 删除热门位商品信息
     * @param listCode 选中的热门位商品编号集合
     * @return
     */
    int deleteHotGoods(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);
}
