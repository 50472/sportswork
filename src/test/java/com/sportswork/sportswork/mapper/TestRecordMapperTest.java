package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.TestRecord;
import com.sportswork.sportswork.core.mapper.TestRecordMapper;
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
public class TestRecordMapperTest {
    @Resource
    private TestRecordMapper testRecordMapper;


    @Test
    @Transactional
    public void testRecordMapper() throws Exception {
        List<TestRecord> testRecordList = testRecordMapper.getAllTestRecords();
        System.out.println(testRecordList.toString());
    }
}
