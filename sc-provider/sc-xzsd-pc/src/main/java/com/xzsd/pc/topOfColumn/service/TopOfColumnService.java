package com.xzsd.pc.topOfColumn.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.topOfColumn.dao.TopOfColumnDao;
import com.xzsd.pc.topOfColumn.entity.TopOfColumnInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @DescriptionDemo 实现类
 * @Author yangmingzhen
 * @Date 2020-03-25
 */
@Service
public class TopOfColumnService {


    @Resource
    private TopOfColumnDao topOfColumnDao;

    /**
     * demo 查询用户详情
     * @param userId
     * @return
     * @Author yangmingzhen
     * @Date 2020-03-26
     */
    public AppResponse getTopOfColumn(String userId) {
        TopOfColumnInfo topOfColumnInfo = topOfColumnDao.getTopOfColumn(userId);
        if(null == topOfColumnInfo){
            return AppResponse.notFound("查询顶部栏失败");
        }
        return AppResponse.success("查询成功！", topOfColumnInfo);
    }
}


