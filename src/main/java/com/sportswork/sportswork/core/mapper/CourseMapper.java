package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Course;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/9 14:44
 * @description
 */
public interface CourseMapper {
    void addCourse(Course course);
    Course getCourse(String id);
    Course getCourseByNumber(String id);
    List<Course> getAllCourses();
    void deleteCourse(String id);
    void setCourse(Course course);
    long getCount();
}
