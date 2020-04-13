package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@Mapper
public interface MenuDao {
    /**
     * 查询全部菜单
     * @return 菜单集合
     */
    List<Menu> listMenus(Menu menu);
    /**
     * 查询对应角色菜单
     * @return 菜单集合
     */
    List<Menu> listRoleMenus(Menu menu);
    /**
     * 删除菜单
     * @param menuCode 菜单编号
     * @return
     */
    int deleteMenu(@Param("menuCode") String menuCode, @Param("userCode") String userCode);
    /**
     * 校验菜单名称是否重复
     * @param menu 菜单信息
     * @return
     */
    int countMenu(Menu menu);
    /**
     * 新增菜单
     * @param menu 菜单信息
     * @return
     */
    int addMenu(Menu menu);
    /**
     * 修改菜单
     * @param menu 菜单信息
     * @return
     */
    int updateMenu(Menu menu);
    /**
     * 查询菜单详情
     * @param menuCode 菜单编号
     * @return 修改结果
     */
    Menu getMenuByMenuCode(@Param("menuCode") String menuCode);
}
