package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Teacher;
import com.sportswork.sportswork.core.entity.Teaching;
import com.sportswork.sportswork.core.mapper.TeachingMapper;
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
 * @date 2020/1/20 21:04
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeachingMapperTest {
    @Resource
    private TeachingMapper teachingMapper;

    private Teaching teaching1 = new Teaching()
            .setCourseId("231")
            .setTeacherId("231")
            .setSemester("2019.3 - 2019.7")
            .setState(1);

    private Teaching teaching2 = new Teaching()
            .setCourseId("2")
            .setTeacherId("231")
            .setSemester("2020.3 - 2020.7")
            .setState(0);


    @Before
    public void initialization(){
        teachingMapper.addTeaching(teaching1);
    }

    @Test
    @Transactional
    public void getAllTeachings() throws Exception {
        List<Teaching> teachingList = teachingMapper.getAllTeachings();
        System.out.println(teachingList.toString());
    }

    @Test
    @Transactional
    public void getTeachingsByTeacher() throws Exception {
        List<Teaching> teachingList = teachingMapper.getTeachingsByTeacher("231");
        System.out.println(teachingList.toString());
    }

    @Test
    @Transactional
    public void getTeachingsBySemester() throws Exception {
        List<Teaching> teachingList = teachingMapper.getTeachingsBySemester("2019.3 - 2019.7");
        System.out.println(teachingList.toString());
    }

    @Test
    @Transactional
    public void getTeachingsByCourse() throws Exception {
        List<Teaching> teachingList = teachingMapper.getTeachingsByCourse("231");
        System.out.println(teachingList.toString());
    }

    @Test
    @Transactional
    public void getTeaching() throws Exception {
        Teaching teaching = teachingMapper.getTeaching("231");
        System.out.println(teaching.getId() + teaching);
    }

    @Test
    @Transactional
    public void addTeaching() throws Exception {
        teachingMapper.addTeaching(teaching2);
        System.out.println(teaching2.getId() + teaching2);
    }

    @Test
    @Transactional
    public void getCount() throws Exception {
        long count = teachingMapper.getCount();
        System.out.println(count);
    }

    @Test
    @Transactional
    public void setTeacher() throws Exception {
        teaching1.setState(1);
        teachingMapper.setTeaching(teaching1);
    }

    @Test
    @Transactional
    public void deleteTeacher() throws Exception {
        teachingMapper.deleteTeaching(teaching1.getId());
    }
}
