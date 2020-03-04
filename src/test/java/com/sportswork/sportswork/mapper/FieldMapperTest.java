package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Field;
import com.sportswork.sportswork.core.mapper.FieldMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 18:12
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FieldMapperTest {
    @Resource
    private FieldMapper fieldMapper;

    @Test
    @Transactional
    public void getAllFields() throws Exception {
        List<Field> fieldList = fieldMapper.getAllFields();
        System.out.println(fieldList.toString());
    }
}
