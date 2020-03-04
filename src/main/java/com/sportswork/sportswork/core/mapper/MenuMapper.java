package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.help.Menu;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/28 23:14
 * @description
 */
public interface MenuMapper {
    void addMenu(Menu menu);
    Menu getMenu(String id);
    List<Menu> getMenusByRole(String roleId);
    List<Menu> getMenusByRoleName(String roleName);
    List<Menu> getFirstLevelMenusByRoleName(String roleName);
    List<Menu> getAllMenus();
    void deleteMenu(String id);
    void setMenu(Menu menu);
    long getCount();
}
