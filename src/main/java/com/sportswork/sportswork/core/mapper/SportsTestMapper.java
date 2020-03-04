package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.SportsTest;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 17:02
 * @description
 */
public interface SportsTestMapper {
    void addSportsTest(SportsTest sportsTest);
    SportsTest getSportsTest(String id);
    List<SportsTest> getAllSportsTests();
    void deleteSportsTest(String id);
    void setSportsTest(SportsTest sportsTest);
    long getCount();
}
