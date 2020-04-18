package com.xzsd.app.userInfo.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.userInfo.dao.UserInfoDao;
import com.xzsd.app.userInfo.entity.UserInformation;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    /**
     * demo 查询用户详情
     * @param userId
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-17
     */
    public AppResponse getUser(String userId){
        int role = userInfoDao.getRole(userId);
        UserInformation userInformation = null;
        if(role == 2){
            //店长信息
            userInformation = userInfoDao.getStore(userId);
            userInformation.setAddress(userInformation.getProvince() + userInformation.getCity() + userInformation.getArea() + userInformation.getAddress());
        }else if(role == 3){
            //司机信息
            userInformation = userInfoDao.getDriver(userId);
        }else if(role == 4){
            //客户信息
            userInformation = userInfoDao.getCustomer(userId);
        }
        if(userInformation == null){
            return AppResponse.notFound("查询用户个人信息失败！");
        }
        return AppResponse.success("查询用户个人信息成功", userInformation);
    }

    /**
     * demo 修改用户密码
     * @param userInformation
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserPassword(UserInformation userInformation){
        //获取原密码
        String userPassword = userInfoDao.getUserPassword(userInformation.getUserId());
        //判断密码是否相同
        boolean bool = PasswordUtils.equalPassword(userInformation.getUserPwd(), userPassword);
        if(!bool){
            return AppResponse.notFound("原密码不正确，请重新输入");
        }
        //密码加密
        String userNewPassword = userInformation.getUserNewPwd();
        String pwd = PasswordUtils.generatePassword(userNewPassword);
        userInformation.setUserNewPwd(pwd);
        int count = userInfoDao.updateUserPassword(userInformation);
        if(0 == count){
            return AppResponse.notFound("修改密码失败");
        }
        return AppResponse.success("修改密码成功");
    }
}
