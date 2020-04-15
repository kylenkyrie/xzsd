package com.xzsd.pc.topOfColumn.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.topOfColumn.service.TopOfColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查user
 * @Author yangmingzhen
 * @Date 2020-03-25
 */
@RestController
@RequestMapping("/user")
public class TopOfColumnController {

    private static final Logger logger = LoggerFactory.getLogger(TopOfColumnController.class);

    @Resource
    private TopOfColumnService topOfColumnService;

    /**
     * demo 查询用户详情
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-26
     */
    @RequestMapping(value = "getTopOfColumn")
    public AppResponse getTopOfColumn() {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return topOfColumnService.getTopOfColumn(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
