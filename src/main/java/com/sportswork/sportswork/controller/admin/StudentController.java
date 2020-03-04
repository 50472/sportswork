package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.Student;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.StudentServiceImp;
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
@Controller("studentController")
public class StudentController {
    @Resource
    private StudentServiceImp studentServiceImp;

    @RequestMapping("/admin/student/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/student/list";
    }

    @RequestMapping("/admin/student/getAllStudents")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllStudents(){
        return new PageDTO<Student>().toPageDTO(studentServiceImp.getAllStudents());
    }

    @RequestMapping(value = "/admin/student/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Student student) {
        studentServiceImp.addStudent(student);
        return "success";
    }


    @RequestMapping(value = "/admin/student/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Student student) {
        studentServiceImp.setStudent(student);
        return "success";
    }

    @RequestMapping(value = "/admin/student/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        studentServiceImp.deleteStudent(id);
        return "true";
    }
}
