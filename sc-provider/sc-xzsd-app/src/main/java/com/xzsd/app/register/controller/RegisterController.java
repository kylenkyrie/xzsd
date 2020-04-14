package com.xzsd.app.register.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.register.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 用户注册
 * @Author yangmingzhen
 * @Date 2020-04-14
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private RegisterService registerService;

    /**
     * demo 新增司机
     * @param registerInfo
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-10
     */
    @PostMapping("clientRegister")
    public AppResponse clientRegister(RegisterInfo registerInfo){
        try{
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            registerInfo.setCreateBy(userId);
            AppResponse appResponse = registerService.clientRegister(registerInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
