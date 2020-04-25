package com.xzsd.app.clientInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientInformation.dao.ClientInformationDao;
import com.xzsd.app.clientInformation.entity.ClientInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ClientInformationService {
    @Resource
    private ClientInformationDao clientInfoDao;
    /**
     * 修改客户店铺邀请码
     * @param clientInfo
     * @return
     * @author yangminzghen
     * @time 2020-04-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateClientInvite(ClientInfo clientInfo){
        int count = clientInfoDao.updateInviteCode(clientInfo);
        if(0 == count){
            return AppResponse.notFound("修改邀请码失败");
        }
        return AppResponse.success("修改邀请码成功");
    }
}
