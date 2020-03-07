package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.entity.Elective;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 11:40
 * @description
 */
public interface IElectiveService {
    Elective addElective(Elective elective);
    Elective getElective(String id);
    List<Elective> getAllElectives();
    List<Elective> getElectivesByStudent(String studentId);
    List<Elective> getElectivesByTeaching(String teachingId);
    List<Elective> getElectivesByStudentOrTeacherOrCourse(
            String studentName, String teacherName, String courseName);
    void deleteElective(String id);
    Elective setElective(Elective elective);
    void studentElective(String teachingId, String studentId);
    void teacherScoring(String electiveId, String score);
}
