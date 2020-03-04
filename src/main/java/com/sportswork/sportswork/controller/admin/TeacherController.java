package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Teacher;
import com.sportswork.sportswork.core.entity.Teacher;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.TeacherServiceImp;
import com.sportswork.sportswork.core.service.impl.TeacherServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 12:11
 * @description
 */
@Slf4j
@Controller("teacherController")
public class TeacherController {
    @Resource
    private TeacherServiceImp teacherServiceImp;

    @RequestMapping("/admin/teacher/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/teacher/list";
    }

    @RequestMapping("/admin/teacher/getAllTeachers")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllTeachers(){
        return new PageDTO<Teacher>().toPageDTO(teacherServiceImp.getAllTeachers());
    }

    @RequestMapping(value = "/admin/teacher/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Teacher teacher) {
        teacherServiceImp.addTeacher(teacher);
        return "success";
    }

    @RequestMapping(value = "/admin/teacher/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Teacher teacher) {
        teacherServiceImp.setTeacher(teacher);
        return "success";
    }

    @RequestMapping(value = "/admin/teacher/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        teacherServiceImp.deleteTeacher(id);
        return "true";
    }
}
