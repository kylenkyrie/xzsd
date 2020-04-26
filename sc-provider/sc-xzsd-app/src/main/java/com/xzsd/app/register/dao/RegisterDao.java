package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.RegisterInfo;

public interface RegisterDao {
    /**
     * 校验注册账号是否重复
     * @param registerInfo 注册信息
     * @return
     */
    int countUserAcct(RegisterInfo registerInfo);
    /**
     * 校验邀请码是否存在
     * @param registerInfo 注册信息
     * @return
     */
    int countInviteCode(RegisterInfo registerInfo);
    /**
     * 客户表新增客户
     * @param registerInfo 注册信息
     * @return
     */
    int addCustomer(RegisterInfo registerInfo);
    /**
     * 用户表新增司机
     * @param registerInfo 注册信息
     * @return
     */
    int addUser(RegisterInfo registerInfo);
}
