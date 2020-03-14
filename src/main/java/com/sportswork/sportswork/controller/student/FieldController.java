package com.sportswork.sportswork.controller.student;

import com.sportswork.sportswork.core.entity.Field;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.FieldServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Controller("s_fieldController")
public class FieldController {
    @Resource
    private FieldServiceImp fieldServiceImp;

    @RequestMapping("/student/field/list")
    @PreAuthorize("hasAnyRole('student')")
    public String List(){
        return "/pages/view/student/fieldList";
    }

    @RequestMapping("/student/field/getAllFields")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getAllFields(){
        return new PageDTO<Field>().toPageDTO(fieldServiceImp.getAllFields());
    }

    @RequestMapping("/student/field/getFieldByNameLike")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getFieldByNameLike(String name){
        return new PageDTO<Field>().toPageDTO(fieldServiceImp.getFieldByNameLike(name));
    }
}
