package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Elective;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/9 14:51
 * @description
 */
public interface ElectiveMapper {
    void addElective(Elective elective);
    Elective getElective(String id);
    Elective getElectiveByStudentIdAndTeachingId(String teachingId, String studentId);
    List<Elective> getAllElectives();
    List<Elective> getElectivesByStudent(String studentId);
    List<Elective> getElectivesByTeaching(String teachingId);
    List<Elective> getElectivesByStudentOrTeacherOrCourse(
            String studentName, String teacherName, String courseName);
    void deleteElective(String id);
    void setElective(Elective elective);
    long getCount();
    void setScore(String id, String score);
}
