package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.TestRecord;
import com.sportswork.sportswork.core.mapper.TestRecordMapper;
import com.sportswork.sportswork.core.service.ITestRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:37
 * @description
 */
@Slf4j
@Service
@Transactional
public class TestRecordServiceImp implements ITestRecordService {
    @Resource
    private TestRecordMapper testRecordMapper;

    @Override
    public void addTestRecord(TestRecord testRecord) {
        testRecordMapper.addTestRecord(testRecord);
    }

    @Override
    public TestRecord getTestRecord(String id) {
        return testRecordMapper.getTestRecord(id);
    }

    @Override
    public List<TestRecord> getAllTestRecords() {
        return testRecordMapper.getAllTestRecords();
    }

    @Override
    public void deleteTestRecord(String id) {
        testRecordMapper.deleteTestRecord(id);
    }

    @Override
    public void setTestRecord(TestRecord testRecord) {
        testRecordMapper.setTestRecord(testRecord);
    }

    @Override
    public long getCount() {
        return testRecordMapper.getCount();
    }
}
