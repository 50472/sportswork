package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.GameEnroll;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 17:30
 * @description
 */
public interface GameEnrollMapper {
    void addGameEnroll(GameEnroll gameEnroll);
    GameEnroll getGameEnroll(String id);
    List<GameEnroll> getAllGameEnrolls();
    void deleteGameEnroll(String id);
    void setGameEnroll(GameEnroll gameEnroll);
    long getCount();
}
