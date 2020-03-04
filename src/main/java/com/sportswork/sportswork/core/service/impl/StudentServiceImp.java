package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Student;
import com.sportswork.sportswork.core.mapper.StudentMapper;
import com.sportswork.sportswork.core.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 11:58
 * @description
 */
@Slf4j
@Service
@Transactional
public class StudentServiceImp implements IStudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student addStudent(Student student) {
        studentMapper.addStudent(student);
        return student;
    }

    @Override
    public Student getStudent(String id) {
        return studentMapper.getStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    @Override
    public void deleteStudent(String id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public Student setStudent(Student student) {
        studentMapper.setStudent(student);
        return student;
    }
}
