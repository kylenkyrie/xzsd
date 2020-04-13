package com.xzsd.pc.goodsClassification.dao;

import com.xzsd.pc.goodsClassification.entity.ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassDao {
    /**
     * 新增商品分类
     * @param classInfo 分类信息
     * @return
     */
    int addClass(ClassInfo classInfo);

    /**
     * 查询商品分类详情
     * @param classId 分类编号
     * @return 查询结果
     */
    ClassInfo getClassById(@Param("classId") String classId);

    /**
     * 修改商品分类信息
     * @param classInfo 商品分类信息
     * @return 修改结果
     */
    int updateClass(ClassInfo classInfo);

    /**
     * 删除商品分类信息
     * @param listCode 选中的分类编号集合
     * @param userCode 更新人
     * @return
     */
    int deleteClass(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);

    /**
     * 查询商品分类列表
     * @return 分类信息
     */
    List<ClassInfo> getNodeTree();
}
