package com.xzsd.pc.topOfColumn.dao;

import com.xzsd.pc.topOfColumn.entity.TopOfColumnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @ClassName UserDao
 * @Description User
 * @Author yangmingzhen
 * @Date 2020-03-25
 */
@Mapper
public interface TopOfColumnDao {
    /**
     * 查询顶部栏信息
     * @param userId 用户编号
     * @return 修改结果
     */
    TopOfColumnInfo getTopOfColumn(@Param("userId") String userId);
}

