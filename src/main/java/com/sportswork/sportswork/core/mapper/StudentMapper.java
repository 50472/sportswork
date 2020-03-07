package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Student;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/9 14:43
 * @description
 */
public interface StudentMapper {
    void addStudent(Student student);
    Student getStudent(String id);
    List<Student> getAllStudents();
    Student getStudentByNumber(String number);
    void deleteStudent(String id);
    void setStudent(Student student);
    long getCount();
}
