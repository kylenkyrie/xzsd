package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.RegionInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * demo 新增
     * @param storeInfo
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-10
     */
    @PostMapping("addStore")
    public AppResponse addGoods(StoreInfo storeInfo){
        try{

            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateBy(userId);
            AppResponse appResponse = storeService.addStore(storeInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("门店新增失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * demo 查询门店详情
     * @param storeId
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-10
     */
    @RequestMapping(value = "getStoreByStoreId")
    public AppResponse getStoreByStoreId(String storeId) {
        try {
            return storeService.getStoreByStoreId(storeId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除门店信息
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-10
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeId){
        try{
            //获取登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeId,userId);
        } catch (Exception e) {
            logger.error("门店删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改门店信息
     * @param storeInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-04-11
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoreInfo storeInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateBy(userId);
            storeInfo.setLastModifiedBy(userId);
            return storeService.updateStore(storeInfo);
        } catch (Exception e) {
            logger.error("修改门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询省市区信息
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-11
     */
    @RequestMapping(value = "listRegion")
    public AppResponse listClass(RegionInfo regionInfo) {
        try {
            return storeService.listRegion(regionInfo);
        } catch (Exception e) {
            logger.error("省市区查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询门店列表（分页）
     * @return
     * @author 杨明镇
     * @Date 2020-04-12
     */
    @RequestMapping(value = "listStore")
    public AppResponse listStore (StoreInfo storeInfo){
        try{
            return storeService.listStoreByPage(storeInfo);

        }catch (Exception e){
            logger.error("查询门店列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
