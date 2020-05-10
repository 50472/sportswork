package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Teaching;
import com.sportswork.sportswork.core.mapper.CourseMapper;
import com.sportswork.sportswork.core.mapper.TeacherMapper;
import com.sportswork.sportswork.core.mapper.TeachingMapper;
import com.sportswork.sportswork.core.service.ITeachingService;
import com.sportswork.sportswork.core.service.dto.TeachingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 12:07
 * @description
 */
@Slf4j
@Service
@Transactional
public class TeachingServiceImp implements ITeachingService {
    @Resource
    private TeachingMapper teachingMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private CourseMapper courseMapper;

    @Override
    public Teaching addTeaching(TeachingDTO teachingDTO) {
        Teaching teaching = new Teaching()
                .setState(teachingDTO.getState())
                .setSemester(teachingDTO.getSemester())
                .setTeacherId(teacherMapper.getTeacherByNumber(teachingDTO.getTeacherNumber()).getId())
                .setCourseId(courseMapper.getCourseByNumber(teachingDTO.getCourseNumber()).getId());
        teachingMapper.addTeaching(teaching);
        return teaching;
    }

    @Override
    public Teaching getTeaching(String id) {
        return teachingMapper.getTeaching(id);
    }

    @Override
    public List<Teaching> getAllTeachings() {
        return teachingMapper.getAllTeachings();
    }

    @Override
    public List<Teaching> getTeachingsByTeacher(String teacherId) {
        return teachingMapper.getTeachingsByTeacher(teacherId);
    }

    @Override
    public List<Teaching> getTeachingsByWeek(int week) {
        return teachingMapper.getTeachingsByWeek(week);
    }

    @Override
    public List<Teaching> getTeachingsBySemester(String semester) {
        return teachingMapper.getTeachingsBySemester(semester);
    }

    @Override
    public List<Teaching> getTeachingsByCourse(String courseId) {
        return teachingMapper.getTeachingsByCourse(courseId);
    }

    @Override
    public List<Teaching> getTeachingsByCourseOrTeacher(String courseName, String teacherName) {
        return teachingMapper.getTeachingsByCourseOrTeacher(courseName,teacherName);
    }

    @Override
    public void deleteTeaching(String id) {
        teachingMapper.deleteTeaching(id);
    }

    @Override
    public Teaching setTeaching(TeachingDTO teachingDTO) {
        Teaching teaching = new Teaching()
                .setId(teachingDTO.getId())
                .setState(teachingDTO.getState())
                .setSemester(teachingDTO.getSemester())
                .setWeek(teachingDTO.getWeek())
                .setTimeArrange(teachingDTO.getTimeArrange())
                .setTeacherId(teacherMapper.getTeacherByNumber(teachingDTO.getTeacherNumber()).getId())
                .setCourseId(courseMapper.getCourseByNumber(teachingDTO.getCourseNumber()).getId());
        teachingMapper.setTeaching(teaching);
        return teaching;
    }

    @Override
    public void stopTeaching(Teaching teaching) {
        teachingMapper.stopTeaching(teaching);
    }
}
