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
    Elective getStudent(String studentId, String teachingId);
    List<Elective> getElectivesByStudent(String studentId);
    List<Elective> getElectivesByTeaching(String teachingId);
    void deleteElective(String studentId, String teachingId);
    void setElective(Elective elective);
}
