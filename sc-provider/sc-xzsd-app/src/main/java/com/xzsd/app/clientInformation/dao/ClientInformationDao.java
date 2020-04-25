package com.xzsd.app.clientInformation.dao;

import com.xzsd.app.clientInformation.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientInformationDao {
    /**
     * 修改邀请码
     * @param clientInfo
     * @return
     */
    int updateInviteCode(ClientInfo clientInfo);
}
