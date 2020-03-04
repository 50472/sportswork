package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Game;
import com.sportswork.sportswork.core.entity.GameEnroll;
import com.sportswork.sportswork.core.mapper.GameEnrollMapper;
import com.sportswork.sportswork.core.service.IGameEnrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:52
 * @description
 */
@Slf4j
@Service
@Transactional
public class GameEnrollServiceImp implements IGameEnrollService {
    @Resource
    private GameEnrollMapper gameEnrollMapper;

    @Override
    public void addGameEnroll(GameEnroll gameEnroll) {
        gameEnrollMapper.addGameEnroll(gameEnroll);
    }

    @Override
    public GameEnroll getGameEnroll(String id) {
        return gameEnrollMapper.getGameEnroll(id);
    }

    @Override
    public List<GameEnroll> getAllGameEnrolls() {
        return getAllGameEnrolls();
    }

    @Override
    public void deleteGameEnroll(String id) {
        gameEnrollMapper.deleteGameEnroll(id);
    }

    @Override
    public void setGameEnroll(GameEnroll gameEnroll) {
        gameEnrollMapper.setGameEnroll(gameEnroll);
    }

    @Override
    public long getCount() {
        return gameEnrollMapper.getCount();
    }
}
