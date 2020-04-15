package com.xzsd.pc.user.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查user
 * @Author yangmingzhen
 * @Date 2020-03-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * demo 新增用户
     * @param userInfo
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-25
     */
    @PostMapping("addUser")
    public AppResponse saveUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询用户列表（分页）
     * @return
     * @author 杨明镇
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers (UserInfo userInfo){
        try{
            return userService.listUsers(userInfo);

        }catch (Exception e){
            logger.error("查询用户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除用户信息
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-25
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userId){
        try{
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return userService.deleteUser(userId,userCode);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改用户
     * @param userInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-03-26
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userCode);
            userInfo.setLastModifiedBy(userCode);
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询用户详情
     * @param userId
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-26
     */
    @RequestMapping(value = "getUserByUserId")
    public AppResponse getUserByUserId(String userId) {
        try {
            return userService.getUserByUserId(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
