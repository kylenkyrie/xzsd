package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * demo 新增司机
     * @param driverInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo){
        // 校验司机账户是否重复
        int countDriverId = driverDao.countDriverId(driverInfo);
        if(0 != countDriverId) {
            return AppResponse.bizError("司机账号已存在，请重新输入！");
        }
        // 密码加密 默认为123456
        String pwd = PasswordUtils.generatePassword(driverInfo.getDriverPwd());
        driverInfo.setDriverPwd(pwd);
        driverInfo.setDriverId(StringUtil.getCommonCode(2));
        driverInfo.setIsDeleted(0);
        //司机表新增司机
        int count = driverDao.addDriver(driverInfo);
        if(count == 0){
            return AppResponse.bizError("司机表新增失败，请重试！");
        }
        //用户表新增司机
        int count1 = driverDao.addUserDriver(driverInfo);
        if(count1 == 0){
            return AppResponse.bizError("用户表新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 修改司机信息
     * @param driverInfo
     * @Author yangmingzhen
     * @Date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo) {
        // 校验司机账户是否重复
        int countDriverId = driverDao.countDriverId(driverInfo);
        if(0 != countDriverId) {
            return AppResponse.bizError("司机账号已存在，请重新输入！");
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        // 密码加密 默认为123456
        String pwd = PasswordUtils.generatePassword(driverInfo.getDriverPwd());
        driverInfo.setDriverPwd(pwd);
        // 修改司机表司机信息
        int count = driverDao.updateDriver(driverInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        // 修改用户表司机信息
        int count1 = driverDao.updateUserDriver(driverInfo);
        if (0 == count1) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询司机详情
     * @param driverId
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-13
     */
    public AppResponse getDriverByDriverId(String driverId) {
        DriverInfo driverInfo = driverDao.getDriverByDriverId(driverId);
        return AppResponse.success("查询成功！",driverInfo);
    }

    /**
     * 功能：获取司机列表
     * 作者：yangmingzhen
     * 时间：2020—04—13
     */
    public AppResponse listDriverByPage(DriverInfo driverInfo) {
        List<DriverInfo> driverInfoList = driverDao.listDriverByPage(driverInfo);
        return AppResponse.success("查询成功！", getPageInfo(driverInfoList));
    }

    /**
     * demo 删除司机表司机
     * @param driverId
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverId,String userCode){
        List<String> listCode = Arrays.asList(driverId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除司机信息
        int count = driverDao.deleteDriver(listCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 删除用户表司机
     * @param driverId
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUserDriver(String driverId,String userCode){
        List<String> listCode = Arrays.asList(driverId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除司机信息
        int count = driverDao.deleteUserDriver(listCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
