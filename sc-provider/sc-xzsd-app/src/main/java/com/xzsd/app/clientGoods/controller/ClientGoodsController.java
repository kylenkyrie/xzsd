package com.xzsd.app.clientGoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.service.ClientGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clientGoods")
public class ClientGoodsController {

    @Resource
    private ClientGoodsService clientGoodsService;
    private static final Logger logger = LoggerFactory.getLogger(ClientGoodsController.class);

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author yangmingzhen
     * @time 2020-04-21
     */
    @PostMapping("getGoods")
    public AppResponse getGoods(String goodsId){
        try {
            return clientGoodsService.getGoods(goodsId);
        }catch (Exception e){
            logger.error("查询商品详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询一级商品分类
     * @return
     * @author yangmingzhen
     * @time 2020-04-21
     */
    @PostMapping("listOneGoodsClassify")
    public AppResponse listOneGoodsClassify(){
        try {
            return clientGoodsService.listOneGoodsClassify();
        }catch (Exception e){
            logger.error("查询商品一级分类失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询二级商品分类及商品
     * @return
     * @author yangmingzhen
     * @time 2020-04-21
     */
    @PostMapping("listGetClassGoods")
    public AppResponse listGetClassGoods(String classifyId){
        try {
            return clientGoodsService.listGetClassGoods(classifyId);
        }catch (Exception e){
            logger.error("查询二级商品分类及商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品评价
     * @param goodsEvaluateInfo
     * @return
     * @author xiekai
     * @time 2020-04-21
     */
    @PostMapping("listGoodsEvaluates")
    public AppResponse listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo){
        try {
            return clientGoodsService.listGoodsEvaluates(goodsEvaluateInfo);
        }catch (Exception e){
            logger.error("查询商品评价失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
