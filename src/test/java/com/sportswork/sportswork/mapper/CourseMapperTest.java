package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Course;
import com.sportswork.sportswork.core.mapper.CourseMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.junit.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author dengwei
 * @date 2020/1/9 17:09
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    private Course course1 = new Course()
            .setName("test1")
            .setClassHour("test1");

    private Course course2 = new Course()
            .setName("test2")
            .setClassHour("test2");

    @Before
    public void initialization(){
        courseMapper.addCourse(course1);
    }

    @Test
    @Transactional
    public void getAllCourses() throws Exception {
        List<Course> courseList = courseMapper.getAllCourses();
        System.out.println(courseList.toString());
    }

    @Test
    @Transactional
    public void getCourse() throws Exception {
        Course course = courseMapper.getCourse("231");
        System.out.println(course.getId() + course);
    }

    @Test
    @Transactional
    public void addCourse() throws Exception {
        courseMapper.addCourse(course2);
        System.out.println(course2.getId() + course2);
    }

    @Test
    @Transactional
    public void getCount() throws Exception {
        long count = courseMapper.getCount();
        System.out.println(count);
    }

    @Test
    @Transactional
    public void setCourse() throws Exception {
        course1.setName("setNameTest");
        courseMapper.setCourse(course1);
    }

    @Test
    @Transactional
    public void deleteCourse() throws Exception {
        courseMapper.deleteCourse(course1.getId());
    }
}
