package com.sportswork.sportswork.controller.teacher;

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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author dengwei
 * @date 2020/2/3 12:11
 * @description
 */
@Slf4j
@Controller("t_electiveController")
public class ElectiveController {
    @Resource
    private ElectiveServiceImp electiveServiceImp;
    @Resource
    private TeachingServiceImp teachingServiceImp;

    @RequestMapping("/teacher/getElectivesByTeaching")
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public Object getElectivesByTeaching(String teachingId){
        return new PageDTO<Elective>().toPageDTO(
                electiveServiceImp.getElectivesByTeaching(teachingId));
    }

    @RequestMapping(value = "/teacher/teacherScoring", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public String teacherScoring(String electiveId, String score) {
        electiveServiceImp.teacherScoring(electiveId, score);
        return "success";
    }

    @RequestMapping("/teacher/teaching/teachingList")
    @PreAuthorize("hasAnyRole('teacher')")
    public String teachingList(){
        return "/pages/view/teacher/teachingList";
    }

    @RequestMapping("/teacher/teaching/getTeachingsByTeacher")
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public Object getTeachingsByTeacher(){
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return new PageDTO<Teaching>().toPageDTO(teachingServiceImp.getTeachingsByTeacher(userDetails.getRoleId()));
    }

    @RequestMapping("/teacher/teaching/getTeachingsByCourseOrTeacher")
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public Object getTeachingsByCourseOrTeacher(String courseName, String teacherName){
        return new PageDTO<Teaching>().toPageDTO(
                teachingServiceImp.getTeachingsByCourseOrTeacher(courseName,teacherName));
    }
}
