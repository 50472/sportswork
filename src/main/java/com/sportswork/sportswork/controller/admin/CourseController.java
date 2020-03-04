package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Course;
import com.sportswork.sportswork.core.entity.Course;
import com.sportswork.sportswork.core.service.ICourseService;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.CourseServiceImp;
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
 * @date 2020/1/9 15:54
 * @description
 */
@Slf4j
@Controller("courseController")
public class CourseController {
    @Resource
    private CourseServiceImp courseServiceImp;

    @RequestMapping("/admin/course/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/course/list";
    }

    @RequestMapping("/admin/course/getAllCourses")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllCourses(){
        return new PageDTO<Course>().toPageDTO(courseServiceImp.getAllCourses());
    }

    @RequestMapping(value = "/admin/course/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Course course) {
        courseServiceImp.addCourse(course);
        return "success";
    }


    @RequestMapping(value = "/admin/course/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Course course) {
        courseServiceImp.setCourse(course);
        return "success";
    }

    @RequestMapping(value = "/admin/course/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        courseServiceImp.deleteCourse(id);
        return "true";
    }
}
