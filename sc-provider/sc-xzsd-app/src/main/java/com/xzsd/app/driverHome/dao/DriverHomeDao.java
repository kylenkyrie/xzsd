package com.xzsd.app.driverHome.dao;

import com.xzsd.app.driverHome.entity.DriverHomeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverHomeDao {
    /**
     * 查询司机负责门店
     * @param driverHomeInfo
     * @return
     */
    List<DriverHomeInfo> listDriverStores(DriverHomeInfo driverHomeInfo);
}
