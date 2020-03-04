package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.entity.GameEnroll;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:51
 * @description
 */
public interface IGameEnrollService {
    void addGameEnroll(GameEnroll gameEnroll);
    GameEnroll getGameEnroll(String id);
    List<GameEnroll> getAllGameEnrolls();
    void deleteGameEnroll(String id);
    void setGameEnroll(GameEnroll gameEnroll);
    long getCount();
}
