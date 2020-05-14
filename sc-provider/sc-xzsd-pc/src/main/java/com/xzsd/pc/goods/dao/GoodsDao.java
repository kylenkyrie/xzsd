package com.xzsd.pc.goods.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goodsClassification.entity.ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GoodsDao
 * @Description Goods
 * @Author yangmingzhen
 * @Date 2020-03-27
 */
@Mapper
public interface GoodsDao {

    /**
     * 统计书号数量
     * @param goodsInfo 商品信息
     * @return
     */
    int countBookId(GoodsInfo goodsInfo);

    /**
     * 新增商品
     * @param goodsInfo 商品信息
     * @return
     */
    int addGoods(GoodsInfo goodsInfo);

    /**
     * 获取所有商品信息
     * @param goodsInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 修改商品信息
     * @param goodsInfo 商品信息
     * @return 修改结果
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 查询商品详情
     * @param goodsId 商品编号
     * @return 修改结果
     */
    GoodsInfo getGoodsByGoodsId(@Param("goodsId") String goodsId);

    /**
     * 校验商品是否被绑定
     * @param listCode 选中的商品编号集合
     * @return
     */
    int countGoodsId(@Param("listCode") List<String> listCode);

    /**
     * 删除商品信息
     * @param listCode 选中的商品编号集合
     * @param userCode 更新人
     * @return
     */
    int deleteGoods(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);

    /**
     * 修改商品状态
     * @return 修改结果
     */
    int updateGoodsStatus(@Param(value = "listUpdate") List<GoodsInfo> listUpdate);

    /**
     * 查询所有商品分类信息
     * @return 所有商品分类信息
     */
    List<ClassInfo> listClass(ClassInfo classInfo);

}

