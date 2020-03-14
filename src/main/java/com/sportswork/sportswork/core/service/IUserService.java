package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.service.dto.UserDTO;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 13:45
 * @description
 */
public interface IUserService {
    boolean addUser(UserDTO userDTO);
    void delUser(String username);
    void stopUser(User user);
    void setUser(UserDTO UserDTO);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    User getUserByOpenId(String openId);
    User getUser(String id);
    Integer getUsersCount();
    Integer getNewUserId();


    void setOpenId(User user);
    void setUsername(User user);
    void setPassword(User user);
    void setPhone(User user);

    void addUserRole(User user);
}
