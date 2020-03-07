package com.sportswork.sportswork.config;

import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.mapper.RoleMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

public class SecurityUserInfo implements Serializable, UserDetails {
    private String userId;
    private String openId;
    private String username;
    private String password;
    private String roleCode;
    private String roleId;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public SecurityUserInfo(User user, boolean accountNonExpired, boolean credentialsNonExpired, boolean enabled) {
        this.userId = user.getId();
        this.openId = user.getOpenId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roleCode = user.getRoleCode();
        this.roleId = user.getRoleId();
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = user.getIsDelBoolean();
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roleCode);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getRoleId() {
        return roleId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
