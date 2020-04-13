package com.xzsd.pc.menu.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;

import com.xzsd.pc.menu.entity.Menu;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@RestController
@RequestMapping("/menu")
@Validated
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;


    /**
     * demo 查询菜单列表
     * @return
     * @author 杨明镇
     * @Date 2020-04-11
     */
    @RequestMapping(value = "listMenus")
    public AppResponse listGoods(Menu menu) {
        try {
            return menuService.listMenus(menu);

        } catch (Exception e) {
            logger.error("查询角色菜单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询角色菜单列表
     * @return
     * @author 杨明镇
     * @Date 2020-04-11
     */
    @RequestMapping(value = "listRoleMenus")
    public AppResponse listRoleGoods(Menu menu) {
        try {
            return menuService.listRoleMenus(menu);

        } catch (Exception e) {
            logger.error("查询角色菜单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除商品信息
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-03-28
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuCode){
        try{
            //获取登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            return menuService.deleteMenu(menuCode,userId);
        } catch (Exception e) {
            logger.error("菜单删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * demo 新增菜单
     * @param menu
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-11
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(Menu menu){
        try{
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            menu.setCreateBy(userId);
            AppResponse appResponse = menuService.addMenu(menu);
            return appResponse;
        } catch (Exception e){
            logger.error("菜单新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改菜单信息
     * @param menu
     * @return AppResponse
     * @author yangmingzhen
     * @Date 2020-04-11
     */
    @PostMapping("updateMenu")
    public AppResponse updateUser(Menu menu) {
        try {
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            menu.setCreateBy(userId);
            menu.setLastModifiedBy(userId);
            return menuService.updateMenu(menu);
        } catch (Exception e) {
            logger.error("修改菜单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询菜单详情
     * @param menuCode
     * @return AppResponse
     * @author 杨明镇
     * @Date 2020-04-11
     */

    @RequestMapping(value = "getMenuByMenuCode")
    public AppResponse getGoodsByGoodsId(String menuCode) {
        try {
            return menuService.getMenuByMenuCode(menuCode);
        } catch (Exception e) {
            logger.error("菜单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}