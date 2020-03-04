package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Course;
import com.sportswork.sportswork.core.help.Menu;
import com.sportswork.sportswork.core.mapper.MenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/1 15:22
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuMapperTest {
    @Resource
    private MenuMapper menuMapper;

    @Test
    @Transactional
    public void getMenusByRole() throws Exception {
        List<Menu> menuList = menuMapper.getMenusByRole("1");
        System.out.println(menuList.toString());
    }

    @Test
    @Transactional
    public void getFirstLevelMenusByRoleName() throws Exception {
        List<Menu> menuList = menuMapper.getFirstLevelMenusByRoleName("ROLE_admin");
        System.out.println(menuList.toString());
    }
}
