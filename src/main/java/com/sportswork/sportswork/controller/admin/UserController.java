package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.dto.UserDTO;
import com.sportswork.sportswork.core.service.impl.RoleServiceImp;
import com.sportswork.sportswork.core.service.impl.UserServiceImp;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 16:49
 * @description
 */
@Slf4j
@Controller("userEntityController")
public class UserController {
    @Resource
    private UserServiceImp userServiceImp;
    @Resource
    private RoleServiceImp roleServiceImp;

    @RequestMapping("/admin/user/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/user/list";
    }

    @RequestMapping("/admin/user/getAllUsers")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllUsers(){
        return new PageDTO<UserDTO>().toPageDTO(
                UserDTO.UserDTOList(userServiceImp.getAllUsers()));
    }

    @RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(UserDTO userDTO) {
        userServiceImp.addUser(userDTO);
        return "success";
    }


    @RequestMapping(value = "/admin/user/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(UserDTO userDTO) {
        userServiceImp.setUser(userDTO);
        return "success";
    }

    @RequestMapping("/admin/user/getAllRoles")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllRoles() {
        return new PageDTO<Role>().toPageDTO(roleServiceImp.getAllRoles());
    }

    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String username) {
        userServiceImp.delUser(username);
        return "true";
    }

    @RequestMapping(value = "/admin/user/stop", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object stop(@RequestBody User user) {
        userServiceImp.stopUser(user);
        return "true";
    }

}
