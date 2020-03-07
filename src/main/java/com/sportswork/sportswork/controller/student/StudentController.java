package com.sportswork.sportswork.controller.student;

import com.sportswork.sportswork.config.SecurityUserInfo;
import com.sportswork.sportswork.core.entity.Student;
import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.service.impl.StudentServiceImp;
import com.sportswork.sportswork.core.service.impl.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author dengwei
 * @date 2020/2/27 23:44
 * @description
 */
@Slf4j
@Controller("s_studentController")
public class StudentController {
    @Resource
    private UserServiceImp userServiceImp;

    @Resource
    private StudentServiceImp studentServiceImp;

    @RequestMapping({"/student/details"})
    @PreAuthorize("hasAnyRole('student')")
    public String details() {
        return "pages/view/student/details";
    }

    @RequestMapping("/student/details/getStudent")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getStudent() {
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return studentServiceImp.getStudent(userDetails.getRoleId());
    }
}
