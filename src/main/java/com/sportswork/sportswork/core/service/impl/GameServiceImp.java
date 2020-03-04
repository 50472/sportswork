package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Game;
import com.sportswork.sportswork.core.mapper.GameMapper;
import com.sportswork.sportswork.core.service.IGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:49
 * @description
 */
@Slf4j
@Service
@Transactional
public class GameServiceImp implements IGameService {
    @Resource
    private GameMapper gameMapper;

    @Override
    public void addGame(Game game) {
        gameMapper.addGame(game);
    }

    @Override
    public Game getGame(String id) {
        return gameMapper.getGame(id);
    }

    @Override
    public List<Game> getAllGames() {
        return gameMapper.getAllGames();
    }

    @Override
    public void deleteGame(String id) {
        gameMapper.deleteGame(id);
    }

    @Override
    public void setGame(Game game) {
        gameMapper.setGame(game);
    }

    @Override
    public long getCount() {
        return gameMapper.getCount();
    }
}
