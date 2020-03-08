package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.help.Menu;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.MenuServiceImp;
import com.sportswork.sportswork.core.service.impl.RoleServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author dengwei
 * @date 2020/3/8 19:36
 * @description
 */
@Slf4j
@Controller("menuController")
public class MenuController {
    @Resource
    private MenuServiceImp menuServiceImp;
    @Resource
    private RoleServiceImp roleServiceImp;

    @RequestMapping("/admin/menu/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/menu/roleList";
    }

    @RequestMapping("/admin/menu/getMenusByRole")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getMenusByRole(String roleId){
        return new PageDTO<Menu>().toPageDTO(menuServiceImp.getMenusByRole(roleId));
    }

    @RequestMapping("/admin/menu/getAllRole")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllRole(){
        return new PageDTO<Role>().toPageDTO(roleServiceImp.getAllRoles());
    }
}
