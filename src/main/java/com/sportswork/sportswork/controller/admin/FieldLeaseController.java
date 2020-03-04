package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.FieldLease;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.FieldLeaseServiceImp;
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
@Controller("fieldLeaseController")
public class FieldLeaseController {
    @Resource
    private FieldLeaseServiceImp fieldLeaseServiceImp;

    @RequestMapping("/admin/fieldLease/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/fieldLease/list";
    }

    @RequestMapping("/admin/fieldLease/getAllFieldLeases")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllFieldLeases(){
        return new PageDTO<FieldLease>().toPageDTO(fieldLeaseServiceImp.getAllFieldLeases());
    }

    @RequestMapping(value = "/admin/fieldLease/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(FieldLease fieldLease) {
        fieldLeaseServiceImp.addFieldLease(fieldLease);
        return "success";
    }


    @RequestMapping(value = "/admin/fieldLease/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(FieldLease fieldLease) {
        fieldLeaseServiceImp.setFieldLease(fieldLease);
        return "success";
    }

    @RequestMapping(value = "/admin/fieldLease/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        fieldLeaseServiceImp.deleteFieldLease(id);
        return "true";
    }
}
