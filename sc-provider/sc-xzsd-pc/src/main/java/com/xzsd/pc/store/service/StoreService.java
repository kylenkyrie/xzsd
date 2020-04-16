package com.xzsd.pc.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.RegionInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * demo 新增门店
     * @param storeInfo 门店信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo){
        // 校验店长id是否存在
        int existManagerId = storeDao.existManagerId(storeInfo);
        if(0 == existManagerId) {
            return AppResponse.bizError("店长id不存在，请重新输入！");
        }
        // 校验店长id是否重复
        int countManagerId = storeDao.countManagerId(storeInfo);
        if(0 != countManagerId) {
            return AppResponse.bizError("店长id重复，请重新输入！");
        }
        storeInfo.setStoreId(StringUtil.getCommonCode(3));
        storeInfo.setInviteCode(StringUtil.getInviteCode(3));
        storeInfo.setIsDeleted(0);
        //新增门店
        int count = storeDao.addStore(storeInfo);
        if(count == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询门店详情
     * @param storeId 门店编号
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-10
     */
    public AppResponse getStoreByStoreId(String storeId) {
        StoreInfo storeInfo = storeDao.getStoreByStoreId(storeId);
        return AppResponse.success("查询成功！",storeInfo);
    }

    /**
     * demo 删除门店
     * @param storeId 门店编号
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId,String userCode){
        List<String> listCode = Arrays.asList(storeId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除门店信息
        int count = storeDao.deleteStore(listCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改门店信息
     * @param storeInfo 门店信息
     * @Author yangmingzhen
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo) {
        // 校验店长id是否存在
        int existManagerId = storeDao.existManagerId(storeInfo);
        if(0 == existManagerId) {
            return AppResponse.bizError("店长id不存在，请重新输入！");
        }
        // 校验店长id是否重复
        int countManagerId = storeDao.countManagerId(storeInfo);
        if(0 != countManagerId) {
            return AppResponse.bizError("店长id重复，请重新输入！");
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改门店信息
        int count = storeDao.updateStore(storeInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询省市区信息
     * @param regionInfo 区域信息
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-11
     */
    public AppResponse listRegion(RegionInfo regionInfo){
        List<RegionInfo> classInfoList = storeDao.listRegion(regionInfo);
        return AppResponse.success("查询成功！",classInfoList);
    }

    /**
     * demo 获取门店列表
     * @param storeInfo 门店信息
     * @Author yangmingzhen
     * @Date 2020-04-10
     */
    public AppResponse listStoreByPage(StoreInfo storeInfo) {
        List<StoreInfo> storeInfoList = storeDao.listStoreByPage(storeInfo);
        return AppResponse.success("查询成功！", getPageInfo(storeInfoList));
    }

}
