package com.sportswork.sportswork.controller.student;

import com.sportswork.sportswork.config.SecurityUserInfo;
import com.sportswork.sportswork.core.entity.Elective;
import com.sportswork.sportswork.core.entity.Teaching;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.ElectiveServiceImp;
import com.sportswork.sportswork.core.service.impl.TeachingServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author dengwei
 * @date 2020/2/3 12:11
 * @description
 */
@Slf4j
@Controller("s_electiveController")
public class ElectiveController {
    @Resource
    private ElectiveServiceImp electiveServiceImp;
    @Resource
    private TeachingServiceImp teachingServiceImp;

    @RequestMapping("/student/elective/electiveList")
    @PreAuthorize("hasAnyRole('student')")
    public String electiveList(){
        return "/pages/view/student/electiveList";
    }

    @RequestMapping("/student/elective/getStudentElectives")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getStudentElectives(){
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return new PageDTO<Elective>().toPageDTO(electiveServiceImp.getElectivesByStudent(userDetails.getRoleId()));
    }

    @RequestMapping(value = "/student/teaching/studentElective", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public String studentElective(String teachingId) {
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        electiveServiceImp.studentElective(teachingId, userDetails.getRoleId());
        return "true";
    }

    @RequestMapping("/student/teaching/teachingList")
    @PreAuthorize("hasAnyRole('student')")
    public String teachingList(){
        return "/pages/view/student/teachingList";
    }

    @RequestMapping("/student/teaching/getAllTeachings")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getAllTeachings(){
        return new PageDTO<Teaching>().toPageDTO(teachingServiceImp.getAllTeachings());
    }

    @RequestMapping("/student/teaching/getTeachingsByCourseOrTeacher")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getTeachingsByCourseOrTeacher(String courseName, String teacherName){
        return new PageDTO<Teaching>().toPageDTO(
                teachingServiceImp.getTeachingsByCourseOrTeacher(courseName,teacherName));
    }

}
