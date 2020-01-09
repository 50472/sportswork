package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Course;
import com.sportswork.sportswork.core.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/9 17:09
 * @description
 */
@SpringBootTest
public class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

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
        System.out.println(course.toString());
    }
}
