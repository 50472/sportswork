package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.UserRole;

/**
 * @author dengwei
 * @date 2020/2/27 23:05
 * @description
 */
public interface UserRoleMapper {
    void addUserRole(UserRole userRole);
    void delUserRole(String id);
    void delUserRoleByUser(String userId);
    long getCount();
}
