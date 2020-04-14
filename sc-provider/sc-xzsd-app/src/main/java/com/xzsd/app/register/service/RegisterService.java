package com.xzsd.app.register.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RegisterService {
    @Resource
    private RegisterDao registerDao;

    /**
     * demo app新增用户
     * @param registerInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse clientRegister(RegisterInfo registerInfo){
        // 校验注册账户是否重复
        int countUserAcct = registerDao.countUserAcct(registerInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 密码加密 默认为123456
        String pwd = PasswordUtils.generatePassword("123456");
        registerInfo.setUserPwd(pwd);
        registerInfo.setUserId(StringUtil.getCommonCode(2));
        registerInfo.setIsDeleted(0);
        //用户表新增用户
        int count = registerDao.addUser(registerInfo);
        if(count == 0){
            return AppResponse.bizError("用户新增失败，请重试！");
        }
        //客户表新增客户
        int count1 = registerDao.addCustomer(registerInfo);
        if(count1 == 0){
            return AppResponse.bizError("客户新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
}
