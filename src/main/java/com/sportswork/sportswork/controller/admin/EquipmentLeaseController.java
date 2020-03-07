package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.EquipmentLease;
import com.sportswork.sportswork.core.entity.Teaching;
import com.sportswork.sportswork.core.service.dto.EquipmentLeaseDTO;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.EquipmentLeaseServiceImp;
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
@Controller("equipmentLeaseController")
public class EquipmentLeaseController {
    @Resource
    private EquipmentLeaseServiceImp equipmentLeaseServiceImp;

    @RequestMapping("/admin/equipmentLease/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/equipmentLease/list";
    }

    @RequestMapping("/admin/equipmentLease/getAllEquipmentLeases")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllEquipmentLeases(){
        return new PageDTO<EquipmentLease>().toPageDTO(equipmentLeaseServiceImp.getAllEquipmentLeases());
    }

    @RequestMapping("/admin/equipmentLease/getEquipmentLeasesByEquipmentOrStudent")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getEquipmentLeasesByEquipmentOrStudent(String equipmentName, String studentName){
        return new PageDTO<EquipmentLease>().toPageDTO(
                equipmentLeaseServiceImp.getEquipmentLeaseByEquipmentNameOrStudentNumber(equipmentName, studentName));
    }

    @RequestMapping(value = "/admin/equipment/addLease", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String addLease(EquipmentLeaseDTO equipmentLeaseDTO) {
        equipmentLeaseServiceImp.addEquipmentLease(equipmentLeaseDTO);
        return "success";
    }

    @RequestMapping(value = "/admin/equipmentLease/returnEquipment", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String returnEquipment(String equipmentLeaseId) {
        equipmentLeaseServiceImp.returnEquipment(equipmentLeaseId);
        return "true";
    }


    @RequestMapping(value = "/admin/equipmentLease/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(EquipmentLease equipmentLease) {
        equipmentLeaseServiceImp.setEquipmentLease(equipmentLease);
        return "success";
    }

    @RequestMapping(value = "/admin/equipmentLease/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        equipmentLeaseServiceImp.deleteEquipmentLease(id);
        return "true";
    }
}
