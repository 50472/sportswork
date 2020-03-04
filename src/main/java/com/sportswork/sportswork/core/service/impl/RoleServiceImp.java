package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.mapper.RoleMapper;
import com.sportswork.sportswork.core.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/28 1:51
 * @description
 */
@Slf4j
@Service
@Transactional
public class RoleServiceImp implements IRoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public Role getRole(String id) {
        return roleMapper.getRole(id);
    }

    @Override
    public Role getRoleByName(String name){
        return roleMapper.getRoleByName(name);
    }

    @Override
    public Role getRoleByDescription(String description){
        return roleMapper.getRoleByDescription(description);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public List<Role> getRolesByUser(String userId) {
        return roleMapper.getRolesByUser(userId);
    }

    @Override
    public void deleteRole(String id) {
        roleMapper.deleteRole(id);
    }

    @Override
    public void setRole(Role role) {
        roleMapper.setRole(role);
    }

    @Override
    public long getCount() {
        return roleMapper.getCount();
    }
}
