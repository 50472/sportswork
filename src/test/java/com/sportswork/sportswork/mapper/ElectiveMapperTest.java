package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Elective;
import com.sportswork.sportswork.core.mapper.ElectiveMapper;
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
 * @date 2020/1/20 20:39
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElectiveMapperTest {
    @Resource
    private ElectiveMapper electiveMapper;

    private Elective elective1 = new Elective()
            .setStudentId("232")
            .setTeachingId("2")
            .setScore("90");
    private Elective elective2 = new Elective()
            .setStudentId("232")
            .setTeachingId("231")
            .setScore("80");


    @Before
    public void initialization(){
        electiveMapper.addElective(elective1);
    }

    @Test
    @Transactional
    public void getAllElectives() throws Exception {
        List<Elective> electiveList = electiveMapper.getAllElectives();
        System.out.println(electiveList.toString());
    }

    @Test
    @Transactional
    public void getElectivesByStudent() throws Exception {
        List<Elective> electiveList = electiveMapper.getElectivesByStudent("231");
        System.out.println(electiveList.toString());
    }

    @Test
    @Transactional
    public void getElectivesByTeaching() throws Exception {
        List<Elective> electiveList = electiveMapper.getElectivesByTeaching("2019.3 - 2019.7");
        System.out.println(electiveList.toString());
    }

    @Test
    @Transactional
    public void getElective() throws Exception {
        Elective elective = electiveMapper.getElective("231");
        System.out.println(elective.getId() + elective);
    }

    @Test
    @Transactional
    public void addElective() throws Exception {
        electiveMapper.addElective(elective2);
        System.out.println(elective2.getId() + elective2);
    }

    @Test
    @Transactional
    public void getCount() throws Exception {
        long count = electiveMapper.getCount();
        System.out.println(count);
    }

    @Test
    @Transactional
    public void setTeacher() throws Exception {
        elective1.setScore("50");
        electiveMapper.setElective(elective1);
    }

    @Test
    @Transactional
    public void deleteTeacher() throws Exception {
        electiveMapper.deleteElective(elective1.getId());
    }
}
