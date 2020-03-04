package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.help.Menu;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/28 23:34
 * @description
 */
public interface IMenuService {
    void addMenu(Menu menu);
    Menu getMenu(String id);
    List<Menu> getMenusByRole(String roleId);
    List<Menu> getMenusByRoleName(String roleName);
    List<Menu> getFirstLevelMenusByRoleName(String roleName);
    void deleteMenu(String id);
    void setMenu(Menu menu);
}
