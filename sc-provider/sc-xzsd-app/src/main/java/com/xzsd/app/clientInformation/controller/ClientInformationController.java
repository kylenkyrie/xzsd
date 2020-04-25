package com.xzsd.app.clientInformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientInformation.entity.ClientInfo;
import com.xzsd.app.clientInformation.service.ClientInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clientInformation")
public class ClientInformationController {
    @Resource
    private ClientInformationService clientInfoService;
    public static final Logger logger = LoggerFactory.getLogger(ClientInformationController.class);
    /**
     * 修改客户店铺邀请码
     * @param clientInfo
     * @return
     * @author yangmingzhen
     * @time 2020-04-24
     */
    @PostMapping("updateClientInvite")
    public AppResponse updateClientInvite(ClientInfo clientInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            clientInfo.setUserId(userId);
            return clientInfoService.updateClientInvite(clientInfo);
        }catch (Exception e){
            logger.error("修改邀请码失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
