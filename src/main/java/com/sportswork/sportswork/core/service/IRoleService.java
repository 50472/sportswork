package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.entity.Role;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/28 1:50
 * @description
 */
public interface IRoleService {
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
