package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Teacher;
import com.sportswork.sportswork.core.entity.Teacher;
import com.sportswork.sportswork.core.mapper.TeacherMapper;
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
 * @date 2020/1/20 20:43
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherMapperTest {
    @Resource
    private TeacherMapper teacherMapper;
    
    private Teacher teacher1 = new Teacher()
            .setName("test1")
            .setSex("男");
    private Teacher teacher2 = new Teacher()
            .setName("test2")
            .setSex("女");

    @Before
    public void initialization(){
        teacherMapper.addTeacher(teacher1);
    }

    @Test
    @Transactional
    public void getAllTeachers() throws Exception {
        List<Teacher> teacherList = teacherMapper.getAllTeachers();
        System.out.println(teacherList.toString());
    }

    @Test
    @Transactional
    public void getTeacher() throws Exception {
        Teacher teacher = teacherMapper.getTeacher("231");
        System.out.println(teacher.getId() + teacher);
    }

    @Test
    @Transactional
    public void addTeacher() throws Exception {
        teacherMapper.addTeacher(teacher2);
        System.out.println(teacher2.getId() + teacher2);
    }

    @Test
    @Transactional
    public void getCount() throws Exception {
        long count = teacherMapper.getCount();
        System.out.println(count);
    }

    @Test
    @Transactional
    public void setTeacher() throws Exception {
        teacher1.setName("setNameTest");
        teacherMapper.setTeacher(teacher1);
    }

    @Test
    @Transactional
    public void deleteTeacher() throws Exception {
        teacherMapper.deleteTeacher(teacher1.getId());
    }
}
