package com.sportswork.sportswork.config;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.mapper.RoleMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleConstance {
    private RoleMapper roleMapper;

    /**
     * 获取权限字符串集合
     * @return 返回权限字符串集合
     */
    public Set<String> getAllRoleSet() {
        Set<String> allRole = new HashSet<>();
        List<Role> roles = roleMapper.getAllRoles();
        for(Role role : roles){
            allRole.add(role.getName());
        }
        return allRole;
    }

    /**
     * 判断权限字符串是否合法
     * @param roleStr 权限字符串
     * @return true为合法
     */
    public boolean checkRoles(String roleStr) {
        Set<String> roleSet = getAllRoleSet();
        String[] roles = roleStr.split(",");
        for (String role : roles) {
            if(!roleSet.contains(role)) {
                return false;
            }
        }
        return true;
    }
}
