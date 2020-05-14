package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description User
 * @Author yangmingzhen
 * @Date 2020-03-25
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsersByPage(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * @param userCode 更新人
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);

    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查询用户信息
     * @param userId 用户编号
     * @return 修改结果
     */
    UserInfo getUserByUserId(@Param("userId") String userId);

    /**
     * 获取当需要修改的用户的密码
     * @param userId
     * @return
     */
    String getUserPassword(@Param("userId") String userId);
}

