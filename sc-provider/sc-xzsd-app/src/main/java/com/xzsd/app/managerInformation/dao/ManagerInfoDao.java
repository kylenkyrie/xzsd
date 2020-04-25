package com.xzsd.app.managerInformation.dao;

import com.xzsd.app.managerInformation.entity.ManagerInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerInfoDao {
    /**
     * 查询店长门下司机信息
     * @param userId
     * @return
     */
    List<ManagerInfo> listManagerDrivers(@Param("userId") String userId);
}
