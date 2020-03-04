package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 14:48
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    @Transactional
    public void getAllUsers() throws Exception {
        List<User> userList = userMapper.getAllUsers();
        System.out.println(userList.toString());
    }
}
