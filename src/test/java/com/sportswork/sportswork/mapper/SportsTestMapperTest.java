package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.SportsTest;
import com.sportswork.sportswork.core.mapper.SportsTestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 18:13
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SportsTestMapperTest {
    @Resource
    private SportsTestMapper sportsTestMapper;

    @Test
    @Transactional
    public void getAllSportsTests() throws Exception {
        List<SportsTest> sportsTestList = sportsTestMapper.getAllSportsTests();
        System.out.println(sportsTestList.toString());
    }
}
