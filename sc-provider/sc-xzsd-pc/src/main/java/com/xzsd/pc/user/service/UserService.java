package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author yangmingzhen
 * @Date 2020-03-25
 */
@Service
public class UserService {


    @Resource
    private UserDao userDao;


    /**
     * demo 新增用户
     * @param userInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo) {
        // 校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 密码加密
        String pwd = PasswordUtils.generatePassword(userInfo.getUserPwd());
        userInfo.setUserPwd(pwd);
        userInfo.setUserId(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);
        // 新增用户
        int count = userDao.addUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询用户列表（分页）
     * @param userInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-25
     */
    public AppResponse listUsers(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 删除用户
     * @param userId
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId,String userCode){
        List<String> listCode = Arrays.asList(userId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = userDao.deleteUser(listCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改用户信息
     * @param userInfo
     * @Author yangmingzhen
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 密码加密 默认为123456
        String pwd = PasswordUtils.generatePassword(userInfo.getUserPwd());
        userInfo.setUserPwd(pwd);
        //检验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询用户详情
     * @param userId
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-26
     */
    public AppResponse getUserByUserId(String userId) {
        UserInfo userInfo = userDao.getUserByUserId(userId);
        return AppResponse.success("查询成功！",userInfo);
    }
}


