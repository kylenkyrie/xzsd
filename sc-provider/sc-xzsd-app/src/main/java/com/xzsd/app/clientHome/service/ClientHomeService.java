package com.xzsd.app.clientHome.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientHome.dao.ClientHomeDao;
import com.xzsd.app.clientHome.entity.HotGoodInfo;
import com.xzsd.app.clientHome.entity.RotationInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientHomeService {

    @Resource
    private ClientHomeDao clientHomeDao;
    /**
     * 查询轮播图
     * @return
     * @author yangmingzhen
     * @date 2020-04-20
     */
    public AppResponse listRotationCharHome(){
        List<RotationInfo> listSlideshow = clientHomeDao.listRotationCharHome();
        if(listSlideshow.size() == 0){
            return AppResponse.notFound("查询首页轮播图失败");
        }
        return AppResponse.success("查询首页轮播图成功", listSlideshow);
    }

    /**
     * 查询热门位商品
     * @return
     * @author yangmingzhen
     * @date 2020-04-20
     */
    public AppResponse listHotGoods(HotGoodInfo hotGoodInfo){
        //获取热门位商品展示数量
        int num = clientHomeDao.getShowCnt();
        hotGoodInfo.setShowCnt(num);
        //查询热门位商品
        List<HotGoodInfo> listHotGoods = clientHomeDao.listHotGoods(hotGoodInfo);
        return AppResponse.success("查询热门位商品成功", listHotGoods);
    }
}
