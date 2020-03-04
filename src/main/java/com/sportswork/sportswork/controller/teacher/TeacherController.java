package com.sportswork.sportswork.controller.teacher;

import com.sportswork.sportswork.core.entity.Teacher;
import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.service.impl.TeacherServiceImp;
import com.sportswork.sportswork.core.service.impl.UserServiceImp;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author dengwei
 * @date 2020/2/27 23:44
 * @description
 */
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private UserServiceImp userServiceImp;

    @Resource
    private TeacherServiceImp teacherServiceImp;

    @RequestMapping({"/details"})
    public String details(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userServiceImp.getUser(userDetails.getUsername());
        Teacher teacher = teacherServiceImp.getTeacher(user.getRoleId());
        model.addAttribute("teacher", teacher);
        return "pages/view/teacher/details";
    }
}
