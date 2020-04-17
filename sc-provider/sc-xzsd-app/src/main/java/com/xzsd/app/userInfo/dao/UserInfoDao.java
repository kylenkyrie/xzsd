package com.xzsd.app.userInfo.dao;

import com.xzsd.app.userInfo.entity.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoDao {
    /**
     * 查询登录用户角色
     * @param userId
     * @return
     */
    int getRole(@Param("userId") String userId);

    /**
     * 查询店长个人信息
     *
     * @param userId
     * @return
     */
    UserInformation getStore(@Param("userId") String userId);

    /**
     * 查询司机个人信息
     *
     * @param userId
     * @return
     */
    UserInformation getDriver(@Param("userId") String userId);

    /**
     * 查询客户个人信息
     * @param userId
     * @return
     */
    UserInformation getCustomer(@Param("userId") String userId);

    /**
     * 获取当前登录用户的密码
     * @param userId
     * @return
     */
    String getUserPassword(@Param("userId") String userId);

    /**
     * 修改用户密码
     * @param userInformation
     * @return
     */
    int updateUserPassword(UserInformation userInformation);
}
