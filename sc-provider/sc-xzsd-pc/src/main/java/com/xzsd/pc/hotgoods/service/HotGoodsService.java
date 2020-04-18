package com.xzsd.pc.hotgoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author yangmingzhen
 * @Date 2020-04-08
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * demo 新增热门商品
     * @param hotGoodsInfo 热门商品信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-08
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){

        // 校验序号是否存在
        int countSortId = hotGoodsDao.countSortId(hotGoodsInfo);
        if(0 != countSortId) {
            return AppResponse.notFound("热门位序号已存在，请重新输入！");
        }
        hotGoodsInfo.setGoodsId(StringUtil.getCommonCode(3));
        hotGoodsInfo.setIsDeleted(0);
        //新增热门商品
        int count = hotGoodsDao.addHotGoods(hotGoodsInfo);
        if(count == 0){
            return AppResponse.notFound("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 功能：获取热门商品列表
     * 作者：yangmingzhen
     * 时间：2020—04—08
     */
    //@SystemLog(operation = "获取热门商品列表。。。。。")
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo) {
        List<HotGoodsInfo> hotgoodsInfoList = hotGoodsDao.listHotGoodsByPage(hotGoodsInfo);
        return AppResponse.success("查询成功！", getPageInfo(hotgoodsInfoList));
    }

    /**
     * demo 所有商品信息
     * @param goodsInfo 在售商品信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-08
     */
    public AppResponse listGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(),goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = hotGoodsDao.listGoodsByPage(goodsInfo);
        //包装对象g
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodsInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 修改热门商品信息
     * @param hotGoodsInfo 热门商品信息
     * @Author yangmingzhen
     * @Date 2020-04-08
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(HotGoodsInfo hotGoodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验序号是否存在
        int countSortId = hotGoodsDao.countSortId(hotGoodsInfo);
        if(0 != countSortId) {
            return AppResponse.notFound("热门位序号已存在，请重新输入！");
        }
        // 修改热门商品信息
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 展示数设置
     * @param hotGoodsInfo 热门商品信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-08
     */
    public AppResponse updateShowCnt(HotGoodsInfo hotGoodsInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改热门商品展示数
        int count = hotGoodsDao.updateShowCnt(hotGoodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
}
