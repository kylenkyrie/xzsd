package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @ClassName DriverDao
 * @Description driver
 * @Author yangmingzhen
 * @Date 2020-04-10
 */
@Mapper
public interface DriverDao {
    /**
     * 校验司机id是否重复
     * @param driverInfo 司机信息
     * @return
     */
    int countDriverId(DriverInfo driverInfo);
    /**
     * 司机表新增司机
     * @param driverInfo 司机信息
     * @return
     */
    int addDriver(DriverInfo driverInfo);
    /**
     * 用户表新增司机
     * @param driverInfo 司机信息
     * @return
     */
    int addUserDriver(DriverInfo driverInfo);
    /**
     * 司机表修改司机信息
     * @param driverInfo 司机信息
     * @return 修改结果
     */
    int updateDriver(DriverInfo driverInfo);
    /**
     * 用户表修改司机信息
     * @param driverInfo 司机信息
     * @return 修改结果
     */
    int updateUserDriver(DriverInfo driverInfo);
    /**
     * 查询司机详情
     * @param driverId 司机编号
     * @return 修改结果
     */
    DriverInfo getDriverByDriverId(@Param("driverId") String driverId);
    /**
     * 获取所有司机信息
     * @param driverInfo 司机信息
     * @return 司机信息
     */
    List<DriverInfo> listDriverByPage(DriverInfo driverInfo);
    /**
     * 删除司机表司机信息
     * @param listCode 选中的司机编号集合
     * @param userCode 更新人
     * @return
     */
    int deleteDriver(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);
    /**
     * 删除司机表司机信息
     * @param listCode 选中的司机编号集合
     * @param userCode 更新人
     * @return
     */
    int deleteUserDriver(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);
}
