package com.xzsd.pc.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.neusoft.util.UUIDUtils;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @Author yangmingzhen
 * @Date 2020-04-11
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * demo 查询菜单
     * @param menu
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-11
     */
    public AppResponse listMenus(Menu menu){
        List<Menu> menuList = menuDao.listMenus(menu);
        return AppResponse.success("查询成功！",menuList);
    }

    /**
     * demo 查询角色菜单
     * @param menu
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-11
     */
    public AppResponse listRoleMenus(Menu menu){
        List<Menu> menuRoleList = menuDao.listRoleMenus(menu);
        return AppResponse.success("查询成功！",menuRoleList);
    }

    /**
     * demo 删除菜单
     * @param menuCode
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuCode,String userCode){
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = menuDao.deleteMenu(menuCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 新增菜单
     * @param menu
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(Menu menu){
        // 校验菜单名称是否重复
        int countMenu = menuDao.countMenu(menu);
        if(0 != countMenu) {
            return AppResponse.bizError("菜单名称重复，请重新输入！");
        }
        menu.setMenuCode(StringUtil.getCommonCode(3));
        menu.setIsDeleted(0);
        //新增菜单
        int count = menuDao.addMenu(menu);
        if(count == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 修改菜单信息
     * @param menu
     * @Author yangmingzhen
     * @Date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(Menu menu) {
        // 校验菜单名称是否重复
        int countMenu = menuDao.countMenu(menu);
        if(0 != countMenu) {
            return AppResponse.bizError("菜单名称重复，请重新输入！");
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改菜单信息
        int count = menuDao.updateMenu(menu);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询菜单详情
     * @param menuCode
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-11
     */
    public AppResponse getMenuByMenuCode(String menuCode) {
        Menu menu = menuDao.getMenuByMenuCode(menuCode);
        return AppResponse.success("查询成功！",menu);
    }
}
