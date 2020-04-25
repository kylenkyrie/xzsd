package com.xzsd.app.driverHome.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driverHome.dao.DriverHomeDao;
import com.xzsd.app.driverHome.entity.DriverHomeInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DriverHomeService {
    @Resource
    private DriverHomeDao driverHomeDao;

    /**
     * 查询司机负责门店
     * @param driverHomeInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-25
     */
    public AppResponse listDriverStores(DriverHomeInfo driverHomeInfo){
        List<DriverHomeInfo> storelist = driverHomeDao.listDriverStores(driverHomeInfo);
        if(storelist.size() == 0){
            return AppResponse.bizError("查询门店信息失败");
        }
        //拼接地址
        for (int i = 0; i < storelist.size(); i++) {
            if (storelist.get(i).getAreaName() != null){
                storelist.get(i).setAddress(storelist.get(i).getProvinceName() + storelist.get(i).getCityName() + storelist.get(i).getAreaName() + storelist.get(i).getAddress());
            }
            else{
                storelist.get(i).setAddress(storelist.get(i).getProvinceName() + storelist.get(i).getCityName() + storelist.get(i).getAddress());
            }
        }
        return AppResponse.success("查询门店信息成功", storelist);
    }
}
