package com.sportswork.sportswork.controller.equipmentAdmin;

import com.sportswork.sportswork.core.entity.Equipment;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.EquipmentServiceImp;
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
@Controller("ea_equipmentController")
public class EquipmentController {
    @Resource
    private EquipmentServiceImp equipmentServiceImp;

    @RequestMapping("/equipment_admin/equipment/list")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    public String List(){
        return "/pages/view/equipment_admin/equipment/list";
    }

    @RequestMapping("/equipment_admin/equipment/getAllEquipments")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getAllEquipments(){
        return new PageDTO<Equipment>().toPageDTO(equipmentServiceImp.getAllEquipments());
    }

    @RequestMapping("/equipment_admin/equipment/getEquipmentByNameLike")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getEquipmentByNameLike(String name){
        return new PageDTO<Equipment>().toPageDTO(equipmentServiceImp.getEquipmentByNameLike(name));
    }
}
