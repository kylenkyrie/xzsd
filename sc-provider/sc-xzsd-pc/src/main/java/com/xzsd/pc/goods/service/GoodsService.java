package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goodsClassification.entity.ClassInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author yangmingzhen
 * @Date 2020-03-27
 */
@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;


    /**
     * demo 新增商品
     * @param goodsInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-27
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsInfo goodsInfo){
        goodsInfo.setGoodsId(StringUtil.getCommonCode(3));
        goodsInfo.setIsDeleted(0);
        //新增商品
        int count = goodsDao.addGoods(goodsInfo);
        if(count == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
            return AppResponse.success("新增成功！");
    }

    /**
     * demo 所有商品信息
     * @param goodsInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-27
     */

    public AppResponse listGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(),goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
        //包装对象g
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodsInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 修改商品信息
     * @param goodsInfo
     * @Author yangmingzhen
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改商品信息
        int count = goodsDao.updateGoods(goodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询商品详情
     * @param goodsId
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-26
     */
    public AppResponse getGoodsByGoodsId(String goodsId) {
        GoodsInfo goodsInfo = goodsDao.getGoodsByGoodsId(goodsId);
        return AppResponse.success("查询成功！",goodsInfo);
    }

    /**
     * demo 删除商品
     * @param goodsId
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId,String userCode){
        List<String> listCode = Arrays.asList(goodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = goodsDao.deleteGoods(listCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改商品状态
     * @param goodsInfo
     * @Author yangmingzhen
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsStatus(GoodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改商品状态
        int count = goodsDao.updateGoodsStatus(goodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * demo 查询所有商品分类信息
     * @param classInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-28
     */

    public AppResponse listClass(ClassInfo classInfo){
        List<ClassInfo> classInfoList = goodsDao.listClass(classInfo);
        return AppResponse.success("查询成功！",classInfoList);
    }

}
