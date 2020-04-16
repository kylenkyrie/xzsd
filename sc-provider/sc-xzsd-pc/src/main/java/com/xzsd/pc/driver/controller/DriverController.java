package com.xzsd.pc.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查Driver
 * @Author yangmingzhen
 * @Date 2020-04-10
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * demo 新增司机
     * @param driverInfo
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-10
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo){
        try{

            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setCreateBy(userId);
            AppResponse appResponse = driverService.addDriver(driverInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("司机新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改司机信息
     * @param driverInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-04-12
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setCreateBy(userId);
            driverInfo.setLastModifiedBy(userId);
            return driverService.updateDriver(driverInfo);
        } catch (Exception e) {
            logger.error("修改司机信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询司机详情
     * @param driverId
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-13
     */
    @RequestMapping(value = "getDriverByDriverId")
    public AppResponse getDriverByDriverId(String driverId) {
        try {
            return driverService.getDriverByDriverId(driverId);
        } catch (Exception e) {
            logger.error("司机查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询司机列表（分页）
     * @return
     * @author 杨明镇
     * @Date 2020-04-12
     */
    @RequestMapping(value = "listDriver")
    public AppResponse listDriver (DriverInfo driverInfo){
        try{
            return driverService.listDriverByPage(driverInfo);

        }catch (Exception e){
            logger.error("查询司机列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除司机信息
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-13
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverId){
        try{
            //获取登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(driverId,userId);
        } catch (Exception e) {
            logger.error("司机删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
