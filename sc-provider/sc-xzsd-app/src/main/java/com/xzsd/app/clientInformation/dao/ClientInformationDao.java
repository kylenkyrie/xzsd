package com.xzsd.app.clientInformation.dao;

import com.xzsd.app.clientInformation.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientInformationDao {
    /**
     * 校验邀请码是否存在
     * @param clientInfo 用户信息
     * @return
     */
    int countInviteCode(ClientInfo clientInfo);

    /**
     * 修改邀请码
     * @param clientInfo
     * @return
     */
    int updateInviteCode(ClientInfo clientInfo);
}
