package com.sportswork.sportswork.config;

import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.service.impl.UserServiceImp;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {
    @Resource
    private UserServiceImp userServiceImp;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userServiceImp.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if(!user.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确");
        }
        if(!user.getIsDelBoolean()){
            throw new IllegalArgumentException("改用户已被禁用");
        }
        userServiceImp.addUserRole(user);
        SecurityUserInfo userInfo = new SecurityUserInfo(user, true,true, true);

        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities); // 构建返回的用户登录成功的token
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
