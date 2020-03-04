package com.sportswork.sportswork.controller.student;

import com.sportswork.sportswork.core.entity.Student;
import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.service.impl.StudentServiceImp;
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
@RequestMapping("/student")
public class StudentController {
    @Resource
    private UserServiceImp userServiceImp;

    @Resource
    private StudentServiceImp studentSerivceImp;

    @RequestMapping({"/details"})
    public String details(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userServiceImp.getUser(userDetails.getUsername());
        Student student = studentSerivceImp.getStudent(user.getRoleId());
        model.addAttribute("student", student);
        return "pages/view/student/details";
    }
}
