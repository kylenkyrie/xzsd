package com.xzsd.pc.store.dao;


import com.xzsd.pc.store.entity.RegionInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StoreDao {

    /**
     * 校验店长id是否重复
     * @param storeInfo 门店信息
     * @return
     */
    int countManagerId(StoreInfo storeInfo);

    /**
     * 校验门店名称是否重复
     * @param storeInfo 门店信息
     * @return
     */
//    int countStoreName(StoreInfo storeInfo);

    /**
     * 校验店长id是否存在
     * @param storeInfo 门店信息
     * @return
     */
    int existManagerId(StoreInfo storeInfo);
    /**
     * 新增门店
     * @param storeInfo 门店信息
     * @return
     */
    int addStore(StoreInfo storeInfo);
    /**
     * 查询门店详情
     * @param storeId 门店编号
     * @return 修改结果
     */
    StoreInfo getStoreByStoreId(@Param("storeId") String storeId);
    /**
     * 删除门店信息
     * @param listCode 选中的门店编号集合
     * @param userCode 更新人
     * @return
     */
    int deleteStore(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);
    /**
     * 修改门店信息
     * @param storeInfo 门店信息
     * @return 修改结果
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 查询省市区信息
     * @return 所有省市区信息
     */
    List<RegionInfo> listRegion(RegionInfo regionInfo);

    /**
     * 获取所有门店信息
     * @param storeInfo 门店信息
     * @return 门店信息
     */
    List<StoreInfo> listStoreByPage(StoreInfo storeInfo);
}
