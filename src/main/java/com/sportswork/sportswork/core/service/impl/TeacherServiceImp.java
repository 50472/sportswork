package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Teacher;
import com.sportswork.sportswork.core.mapper.TeacherMapper;
import com.sportswork.sportswork.core.service.ITeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 12:02
 * @description
 */
@Slf4j
@Service
@Transactional
public class TeacherServiceImp implements ITeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherByNumber(String number) {
        return teacherMapper.getTeacherByNumber(number);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
        return teacher;
    }

    @Override
    public Teacher getTeacher(String id) {
        return teacherMapper.getTeacher(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.getAllTeachers();
    }

    @Override
    public void deleteTeacher(String id) {
        teacherMapper.deleteTeacher(id);
    }

    @Override
    public Teacher setTeacher(Teacher teacher) {
        teacherMapper.setTeacher(teacher);
        return teacher;
    }
}
