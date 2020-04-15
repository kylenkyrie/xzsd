package com.xzsd.pc.goodsClassification.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsClassification.entity.ClassInfo;
import com.xzsd.pc.goodsClassification.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查goodsClassification
 * @Author yangmingzhen
 * @Date 2020-03-31
 */
@RestController
@RequestMapping("/goodsClassifiaction")
public class ClassController {
    private static final Logger logger = LoggerFactory.getLogger(ClassController.class);

    @Resource
    private ClassService classService;

    /**
     * demo 新增商品分类
     * @param classInfo
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-04
     */
    @PostMapping("addClass")
    public AppResponse addPicture(ClassInfo classInfo){
        try{
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            classInfo.setCreateBy(userId);
            AppResponse appResponse = classService.addClass(classInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("分类新增失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * demo 查询商品分类详情
     * @param classId
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-04
     */
    @RequestMapping(value = "getClassById")
    public AppResponse getClassById(String classId) {
        try {
            return classService.getClassById(classId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改商品分类
     * @param classInfo
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-04-04
     */
    @PostMapping("updateClass")
    public AppResponse updateClass(ClassInfo classInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            classInfo.setCreateBy(userId);
            classInfo.setLastModifiedBy(userId);
            return classService.updateClass(classInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除商品分类信息
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-04
     */
    @PostMapping("deleteClass")
    public AppResponse deleteClass(String classId){
        try{
            //获取商品id
            String userId = SecurityUtils.getCurrentUserId();
            return classService.deleteClass(classId,userId);
        } catch (Exception e) {
            logger.error("分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询商品分类列表
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-11
     */
    @RequestMapping(value = "getNodeTree")
    public AppResponse getNodeTree() {
        try {
            return classService.getNodeTree();
        } catch (Exception e) {
            logger.error("分类列表查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
