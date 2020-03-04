package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.User;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 13:35
 * @description
 */
public interface UserMapper {
    void addUser(User user);
    void delUser(String username);
    void stopUser(User user);
    void setUser(User user);
    void setOpenId(User user);
    void setUsername(User user);
    void setPassword(User user);
    void setPhone(User user);
    void setUserIsDel(User user);
    List<User> getAllUsers();
    User getUserByOpenId(String openId);
    User getUserByUsername(String username);
    User getUser(String id);
    Integer getUsersCount();
    Integer getUsersMaxId();
//    String getUserAuthority(User user);
}
