package com.xzsd.app.clientHome.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientHome.entity.HotGoodInfo;
import com.xzsd.app.clientHome.service.ClientHomeService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


@RestController
@RequestMapping("/clientHome")
public class ClientHomeController {

    @Resource
    private ClientHomeService clientHomeService;
    private static final Logger logger = LoggerFactory.getLogger(ClientHomeController.class);

    /**
     * 查询app首页轮播图
     * @return AppResponse
     * @author yangmingzhen
     * @time 2020-04-14
     */
    @PostMapping("listRotationCharHome")
    public AppResponse listRotationCharHome(){
        try {
            return clientHomeService.listRotationCharHome();
        }catch (Exception e){
            logger.error("查询首页轮播图失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门位商品
     * @return AppResponse
     * @author yangmingzhen
     * @time 2020-04-20
     */
    @PostMapping("listHotGoods")
    public AppResponse listHotGoods(HotGoodInfo hotGoodInfo){
        try {
            return clientHomeService.listHotGoods(hotGoodInfo);
        }catch (Exception e){
            logger.error("查询首页热门位商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
