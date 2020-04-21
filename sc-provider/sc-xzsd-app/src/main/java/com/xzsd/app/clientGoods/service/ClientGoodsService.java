package com.xzsd.app.clientGoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientGoods.dao.ClientGoodsDao;
import com.xzsd.app.clientGoods.entity.GoodsClassInfo;
import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.entity.GoodsInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientGoodsService {
    @Resource
    private ClientGoodsDao clientGoodsDao;

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author yangmingzhen
     * @time 2020-04-21
     */
    public AppResponse getGoods(String goodsId){
        GoodsInfo goodsInfo = clientGoodsDao.getGoods(goodsId);
        return AppResponse.success("查询商品详情成功", goodsInfo);
    }

    /**
     * 查询一级商品分类
     * @return
     * @author yaangmingzhen
     * @time 2020-04-21
     */
    public AppResponse listOneGoodsClassify(){
        List<GoodsClassInfo> oneClassifyList = clientGoodsDao.listOneGoodsClassify();
        if(oneClassifyList.size() == 0){
            return AppResponse.notFound("查询一级商品分类失败");
        }
        return AppResponse.success("查询一级商品分类成功", oneClassifyList);
    }

    /**
     * 查询二级商品分类及商品
     * @return
     * @author yangminzhen
     * @time 2020-04-21
     */
    public AppResponse listGetClassGoods(String classifyId){
        List<GoodsClassInfo> twoClassifyList = clientGoodsDao.listGetClassGoods(classifyId);
        if(twoClassifyList.size() == 0){
            return AppResponse.notFound("查询二级商品分类及商品失败");
        }
        return AppResponse.success("查询二级商品分类及商品成功", twoClassifyList);
    }

    /**
     * 查询商品评价
     * @param goodsEvaluateInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-21
     */
    public AppResponse listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo){
        PageHelper.startPage(goodsEvaluateInfo.getPageNum(), goodsEvaluateInfo.getPageSize());
        List<GoodsEvaluateInfo> listGoodsEvaluates = clientGoodsDao.listGoodsEvaluates(goodsEvaluateInfo);
        PageInfo<GoodsEvaluateInfo> pageData = new PageInfo<GoodsEvaluateInfo>(listGoodsEvaluates);
        return AppResponse.success("查询商品评价成功",pageData);
    }
}
