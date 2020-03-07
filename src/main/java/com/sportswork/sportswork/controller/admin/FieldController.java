package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.Field;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.FieldServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author dengwei
 * @date 2020/2/3 12:11
 * @description
 */
@Slf4j
@Controller("fieldController")
public class FieldController {
    @Resource
    private FieldServiceImp fieldServiceImp;

    @RequestMapping("/admin/field/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/field/list";
    }

    @RequestMapping("/admin/field/getAllFields")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllFields(){
        return new PageDTO<Field>().toPageDTO(fieldServiceImp.getAllFields());
    }

    @RequestMapping("/admin/field/getFieldByNameLike")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getFieldByNameLike(String name){
        return new PageDTO<Field>().toPageDTO(fieldServiceImp.getFieldByNameLike(name));
    }

    @RequestMapping(value = "/admin/field/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Field field) {
        fieldServiceImp.addField(field);
        return "success";
    }


    @RequestMapping(value = "/admin/field/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Field field) {
        fieldServiceImp.setField(field);
        return "success";
    }

    @RequestMapping(value = "/admin/field/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        fieldServiceImp.deleteField(id);
        return "true";
    }
}
