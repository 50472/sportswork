package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.FieldLease;
import com.sportswork.sportswork.core.mapper.FieldLeaseMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.junit.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 18:12
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FieldLeaseMapperTest {
    @Resource
    private FieldLeaseMapper fieldLeaseMapper;

    @Test
    @Transactional
    public void getAllFieldLeases() throws Exception {
        List<FieldLease> fieldLeaseList = fieldLeaseMapper.getAllFieldLeases();
        System.out.println(fieldLeaseList.toString());
    }
}
