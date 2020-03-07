package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.Equipment;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.EquipmentServiceImp;
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
@Controller("equipmentController")
public class EquipmentController {
    @Resource
    private EquipmentServiceImp equipmentServiceImp;

    @RequestMapping("/admin/equipment/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/equipment/list";
    }

    @RequestMapping("/admin/equipment/getAllEquipments")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllEquipments(){
        return new PageDTO<Equipment>().toPageDTO(equipmentServiceImp.getAllEquipments());
    }

    @RequestMapping("/admin/equipment/getEquipmentByNameLike")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getEquipmentByNameLike(String name){
        return new PageDTO<Equipment>().toPageDTO(equipmentServiceImp.getEquipmentByNameLike(name));
    }

    @RequestMapping(value = "/admin/equipment/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Equipment equipment) {
        equipmentServiceImp.addEquipment(equipment);
        return "success";
    }


    @RequestMapping(value = "/admin/equipment/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Equipment equipment) {
        equipmentServiceImp.setEquipment(equipment);
        return "success";
    }

    @RequestMapping(value = "/admin/equipment/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        equipmentServiceImp.deleteEquipment(id);
        return "true";
    }
}
