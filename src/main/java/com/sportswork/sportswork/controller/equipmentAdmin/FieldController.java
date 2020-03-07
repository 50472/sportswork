package com.sportswork.sportswork.controller.equipmentAdmin;

import com.sportswork.sportswork.core.entity.Field;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.FieldServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author dengwei
 * @date 2020/2/3 12:11
 * @description
 */
@Slf4j
@Controller("ea_fieldController")
public class FieldController {
    @Resource
    private FieldServiceImp fieldServiceImp;

    @RequestMapping("/equipment_admin/field/list")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    public String List(){
        return "/pages/view/equipment_admin/field/list";
    }

    @RequestMapping("/equipment_admin/field/getAllFields")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getAllFields(){
        return new PageDTO<Field>().toPageDTO(fieldServiceImp.getAllFields());
    }

    @RequestMapping("/equipment_admin/field/getFieldByNameLike")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getFieldByNameLike(String name){
        return new PageDTO<Field>().toPageDTO(fieldServiceImp.getFieldByNameLike(name));
    }
}
