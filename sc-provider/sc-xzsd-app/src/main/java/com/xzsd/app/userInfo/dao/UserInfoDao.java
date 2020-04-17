package com.xzsd.app.userInfo.dao;

import com.xzsd.app.userInfo.entity.UserInfo;
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
    UserInfo getStore(@Param("userId") String userId);

    /**
     * 查询司机个人信息
     *
     * @param userId
     * @return
     */
    UserInfo getDriver(@Param("userId") String userId);

    /**
     * 查询客户个人信息
     * @param userId
     * @return
     */
    UserInfo getCustomer(@Param("userId") String userId);
}
