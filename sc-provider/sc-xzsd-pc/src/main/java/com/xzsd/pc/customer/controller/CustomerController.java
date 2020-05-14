package com.xzsd.pc.customer.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查customer
 * @Author yangmingzhen
 * @Date 2020-04-04
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;


    /**
     * demo 查询客户列表（分页）
     * @return
     * @author 杨明镇
     * @Date 2020-04-04
     */
    @RequestMapping(value = "listCustomer")
    public AppResponse listCustomer(CustomerInfo customerInfo){
        try{
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            customerInfo.setloginUserId(userId);
            return customerService.listCustomer(customerInfo);
        }catch (Exception e){
            logger.error("查询客户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
