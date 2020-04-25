package com.xzsd.app.managerInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.managerInformation.dao.ManagerInfoDao;
import com.xzsd.app.managerInformation.entity.ManagerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerInfoService {
    @Resource
    private ManagerInfoDao managerInfoDao;
    /**
     * 查询店长门下司机信息
     * @return
     * @author yangmingzhen
     * @time 2020-04-25
     */
    public AppResponse listManagerDrivers(String userId){
        List<ManagerInfo> list = managerInfoDao.listManagerDrivers(userId);
        if(list.size() == 0){
            return AppResponse.notFound("查询司机信息列表失败");
        }
        return AppResponse.success("查询司机信息列表成功", list);
    }
}
