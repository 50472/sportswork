package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Role;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/27 23:01
 * @description
 */
public interface RoleMapper {
    void addRole(Role role);
    Role getRole(String id);
    Role getRoleByName(String name);
    Role getRoleByDescription(String description);
    List<Role> getAllRoles();
    List<Role> getRolesByUser(String userId);
    void deleteRole(String id);
    void setRole(Role role);
    long getCount();
}
