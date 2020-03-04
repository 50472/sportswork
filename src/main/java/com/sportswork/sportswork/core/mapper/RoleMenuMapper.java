package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.help.RoleMenu;


/**
 * @author dengwei
 * @date 2020/2/28 23:28
 * @description
 */
public interface RoleMenuMapper {
    void addRoleMenu(RoleMenu roleMenu);
    void deleteRoleMenu(String id);
    long getCount();
}
