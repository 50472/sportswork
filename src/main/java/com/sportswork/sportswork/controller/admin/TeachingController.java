package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.Teaching;
import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.dto.TeachingDTO;
import com.sportswork.sportswork.core.service.impl.TeachingServiceImp;
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
@Controller("teachingController")
public class TeachingController {
    @Resource
    private TeachingServiceImp teachingServiceImp;

    @RequestMapping("/admin/teaching/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/teaching/list";
    }

    @RequestMapping("/admin/teaching/getAllTeachings")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllTeachings(){
        return new PageDTO<Teaching>().toPageDTO(teachingServiceImp.getAllTeachings());
    }

    @RequestMapping("/admin/teaching/getTeachingsByCourseOrTeacher")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getTeachingsByCourseOrTeacher(String courseName, String teacherName){
        return new PageDTO<Teaching>().toPageDTO(
                teachingServiceImp.getTeachingsByCourseOrTeacher(courseName,teacherName));
    }

    @RequestMapping(value = "/admin/teaching/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(TeachingDTO teachingDTO) {
        teachingServiceImp.addTeaching(teachingDTO);
        return "success";
    }


    @RequestMapping(value = "/admin/teaching/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(TeachingDTO teachingDTO) {
        teachingServiceImp.setTeaching(teachingDTO);
        return "success";
    }

    @RequestMapping(value = "/admin/teaching/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        teachingServiceImp.deleteTeaching(id);
        return "true";
    }

    @RequestMapping(value = "/admin/teaching/stop", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object stop(@RequestBody Teaching teaching) {
        teachingServiceImp.stopTeaching(teaching);
        return "true";
    }
}
