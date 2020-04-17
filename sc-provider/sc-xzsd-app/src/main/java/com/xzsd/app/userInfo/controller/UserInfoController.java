package com.xzsd.app.userInfo.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.userInfo.entity.UserInformation;
import com.xzsd.app.userInfo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    /**
     * demo 查询用户个人信息
     * @param
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-17
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUser() {
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return userInfoService.getUser(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改用户密码
     * @param
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-17
     */
    @PostMapping("updateUserPassword")
    public AppResponse updateUserPassword(UserInformation userInformation){
        String userId = SecurityUtils.getCurrentUserId();
        userInformation.setUserId(userId);
        try {
            return userInfoService.updateUserPassword(userInformation);
        }catch (Exception e){
            logger.error("修改密码失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
