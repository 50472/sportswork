package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Game;
import com.sportswork.sportswork.core.mapper.GameMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 18:15
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameMapperTest {
    @Resource
    private GameMapper gameMapper;

    @Test
    @Transactional
    public void getAllGames() throws Exception {
        List<Game> gameList = gameMapper.getAllGames();
        System.out.println(gameList.toString());
    }
}
