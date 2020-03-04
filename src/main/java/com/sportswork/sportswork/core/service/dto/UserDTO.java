package com.sportswork.sportswork.core.service.dto;

import com.sportswork.sportswork.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/2 2:50
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO {
    private String username;
    private String password;
    private String phone;
    private int isDel;
    private String roleName;
    private String roleCode;

    /**
     * 新密码
     */
    private String newPassword;

    public UserDTO(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.isDel = user.getIsDel();
        this.roleName = user.getRoleDescription();
        this.roleCode = user.getRoleCode();
    }

    public static List<UserDTO> UserDTOList(List<User> userList){
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : userList){
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }

    public void Assignment(User user){
        user.setUsername(this.username)
            .setPassword(this.password)
            .setPhone(this.phone)
            .setIsDel(this.isDel);
    }

    public void Edit(User user){
        user.setPassword(this.password)
            .setPhone(this.phone)
            .setIsDel(this.isDel);
    }
}
