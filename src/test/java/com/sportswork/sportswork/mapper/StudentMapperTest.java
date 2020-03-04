package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Course;
import com.sportswork.sportswork.core.entity.Student;
import com.sportswork.sportswork.core.mapper.StudentMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/20 19:37
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    private Student student1 = new Student()
            .setName("test1")
            .setNumber("201617010130")
            .setProfession("计算机科学")
            .setSex("男");

    private Student student2 = new Student()
            .setName("test2")
            .setNumber("201617010131")
            .setProfession("信息管理")
            .setSex("男");

    @Before
    public void initialization(){
        studentMapper.addStudent(student1);
    }

    @Test
    @Transactional
    public void getAllStudents() throws Exception {
        List<Student> studentList = studentMapper.getAllStudents();
        System.out.println(studentList.toString());
    }

    @Test
    @Transactional
    public void getStudent() throws Exception {
        Student student = studentMapper.getStudent("231");
        System.out.println(student.getId() + student);
    }

    @Test
    @Transactional
    public void addStudent() throws Exception {
        studentMapper.addStudent(student2);
        System.out.println(student2.getId() + student2);
    }

    @Test
    @Transactional
    public void getCount() throws Exception {
        long count = studentMapper.getCount();
        System.out.println(count);
    }

    @Test
    @Transactional
    public void setStudent() throws Exception {
        student1.setName("setNameTest");
        studentMapper.setStudent(student1);
    }

    @Test
    @Transactional
    public void deleteStudent() throws Exception {
        studentMapper.deleteStudent(student1.getId());
    }
}
