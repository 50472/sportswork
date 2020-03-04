package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Game;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 17:30
 * @description
 */
public interface GameMapper {
    void addGame(Game game);
    Game getGame(String id);
    List<Game> getAllGames();
    void deleteGame(String id);
    void setGame(Game game);
    long getCount();
}
