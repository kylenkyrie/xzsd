package com.xzsd.pc.goodsClassification.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goodsClassification.dao.ClassDao;
import com.xzsd.pc.goodsClassification.entity.ClassInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ClassService {
    @Resource
    private ClassDao classDao;

    /**
     * demo 新增商品分类
     * @param classInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-04
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addClass(ClassInfo classInfo){
        //检验商品分类是否存在
        int countGoodsClass = classDao.countGoodsClass(classInfo);
        if (0 != countGoodsClass) {
            return AppResponse.bizError("商品分类已存在，请重新输入！");
        }
        classInfo.setClassId(StringUtil.getCommonCode(3));
        classInfo.setIsDeleted(0);
        //新增商品分类
        int count = classDao.addClass(classInfo);
        if(count == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询商品分类详情
     * @param classId
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-04
     */
    public AppResponse getClassById(String classId) {
        ClassInfo classInfo = classDao.getClassById(classId);
        return AppResponse.success("查询成功！",classInfo);
    }

    /**
     * demo 修改商品分类信息
     * @param classInfo
     * @Author yangmingzhen
     * @Date 2020-04-04
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateClass(ClassInfo classInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        //检验商品分类是否存在
        int countGoodsClass = classDao.countGoodsClass(classInfo);
        if (0 != countGoodsClass) {
            return AppResponse.bizError("商品分类已存在，请重新输入！");
        }
        // 修改商品分类信息
        int count = classDao.updateClass(classInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除商品分类
     * @param classId
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-04
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteClass(String classId,String userCode){
        AppResponse appResponse = AppResponse.success("删除成功！");
        int counts = classDao.countGoodsClassSon(classId);
        if(counts != 0){
            appResponse = AppResponse.bizError("删除的分类有子分类，删除失败！");
        }
        // 删除商品分类
        int count = classDao.deleteClass(classId,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询商品分类列表
     * @Author yangmingzhen
     * @Date 2020-04-11
     */
    public AppResponse getNodeTree(){
        List<ClassInfo> classInfoList = classDao.getNodeTree();
        return AppResponse.success("查询成功！",classInfoList);
    }
}
