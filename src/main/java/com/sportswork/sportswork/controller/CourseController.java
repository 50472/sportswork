package com.sportswork.sportswork.controller;

import com.sportswork.sportswork.core.entity.Course;
import com.sportswork.sportswork.core.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private ICourseService courseServiceImp;

    @RequestMapping("/admin/course/list")
//    @PreAuthorize("hasAnyRole('admin')")
    public String List(Model model) {
        log.info("--Courses list--");
        List<Course> courseList = courseServiceImp.getAllCourses();
        model.addAttribute("courseList", courseList);
        return "pages/view/course/list";
    }


    @RequestMapping("/admin/course/toAdd")
//    @PreAuthorize("hasAnyRole('admin')")
    public String toAdd(Model model) {
        log.info("--Courses Add--");
        Course course = new Course();
        model.addAttribute("course", course);
        return "pages/view/Course/add";
    }

    @RequestMapping(value = "/admin/course/add", method = RequestMethod.POST)
//    @PreAuthorize("hasAnyRole('admin')")
    public String add(Course course) {
        courseServiceImp.addCourse(course);
        return "redirect:/admin/course/list";
    }


    @RequestMapping("/admin/course/toEdit")
//    @PreAuthorize("hasAnyRole('admin')")
    public String toEdit(Model model, String id) {
        Course course = courseServiceImp.getCourse(id);
        model.addAttribute("course", course);
        return "pages/view/course/edit";
    }

    @RequestMapping(value = "/admin/course/edit", method = RequestMethod.POST)
//    @PreAuthorize("hasAnyRole('admin')")
    public String edit(Course course) {
        courseServiceImp.setCourse(course);
        return "redirect:/admin/course/list";
    }

    @RequestMapping("/admin/course/delete")
//    @PreAuthorize("hasAnyRole('admin')")
    public String delete(String id) {
        courseServiceImp.deleteCourse(id);
        return "redirect:/admin/course/list";
    }
}
