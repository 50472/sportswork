package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Course;
import com.sportswork.sportswork.core.mapper.CourseMapper;
import com.sportswork.sportswork.core.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/9 15:45
 * @description
 */
@Slf4j
@Service
@Transactional
public class CourseServiceImp implements ICourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        courseMapper.deleteCourse(courseId);
    }

    @Override
    public void setCourse(Course course) {
        courseMapper.setCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }

    @Override
    public Course getCourse(String courseId) {
        return courseMapper.getCourse(courseId);
    }

    @Override
    public Course getCourseByNumber(String number) {
        return courseMapper.getCourseByNumber(number);
    }
}
