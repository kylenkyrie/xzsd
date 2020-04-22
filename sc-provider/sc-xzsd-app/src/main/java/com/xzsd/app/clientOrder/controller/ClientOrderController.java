package com.xzsd.app.clientOrder.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.service.ClientOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clientOrder")
public class ClientOrderController {

    @Resource
    private ClientOrderService clientOrderService;
    public static final Logger logger = LoggerFactory.getLogger(ClientOrderController.class);

    /**
     *新增订单
     * @param clientOrderInfo
     * @return
     * @author 杨明镇
     * @time 2020-04-22
     */
    @PostMapping("addOrder")
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo){
        //获取当前登录人
        String userId = SecurityUtils.getCurrentUserId();
        clientOrderInfo.setUserId(userId);
        try {
            return clientOrderService.addOrder(clientOrderInfo);
        }catch (Exception e){
            logger.error("新增订单失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
