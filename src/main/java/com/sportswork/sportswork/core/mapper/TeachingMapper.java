package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Teaching;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/9 14:52
 * @description
 */
public interface TeachingMapper {
    void addTeaching(Teaching teaching);
    Teaching getTeaching(String id);
    List<Teaching> getAllTeachings();
    List<Teaching> getTeachingsByTeacher(String teacherId);
    List<Teaching> getTeachingsByWeek(int week);
    List<Teaching> getTeachingsBySemester(String semester);
    List<Teaching> getTeachingsByCourse(String courseId);
    List<Teaching> getTeachingsByCourseOrTeacher(String courseName, String teacherName);
    void deleteTeaching(String id);
    void setTeaching(Teaching teaching);
    void stopTeaching(Teaching teaching);
    long getCount();
}
