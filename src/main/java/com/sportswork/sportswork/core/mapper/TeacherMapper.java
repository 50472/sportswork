package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Teacher;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/9 14:43
 * @description
 */
public interface TeacherMapper {
    void addTeacher(Teacher teacher);
    Teacher getTeacher(String id);
    Teacher getTeacherByNumber(String number);
    List<Teacher> getAllTeachers();
    void deleteTeacher(String id);
    void setTeacher(Teacher teacher);
    long getCount();
}
