package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.SportsTest;
import com.sportswork.sportswork.core.mapper.SportsTestMapper;
import com.sportswork.sportswork.core.service.ISportsTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:33
 * @description
 */
@Slf4j
@Service
@Transactional
public class SportsTestServiceImp implements ISportsTestService {
    @Resource
    private SportsTestMapper sportsTestMapper;

    @Override
    public void addSportsTest(SportsTest sportsTest) {
        sportsTestMapper.addSportsTest(sportsTest);
    }

    @Override
    public SportsTest getSportsTest(String id) {
        return sportsTestMapper.getSportsTest(id);
    }

    @Override
    public List<SportsTest> getAllSportsTests() {
        return sportsTestMapper.getAllSportsTests();
    }

    @Override
    public void deleteSportsTest(String id) {
        sportsTestMapper.deleteSportsTest(id);
    }

    @Override
    public void setSportsTest(SportsTest sportsTest) {
        sportsTestMapper.setSportsTest(sportsTest);
    }

    @Override
    public long getCount() {
        return sportsTestMapper.getCount();
    }
}
