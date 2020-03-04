package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.TestRecord;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 17:11
 * @description
 */
public interface TestRecordMapper {
    void addTestRecord(TestRecord testRecord);
    TestRecord getTestRecord(String id);
    List<TestRecord> getAllTestRecords();
    void deleteTestRecord(String id);
    void setTestRecord(TestRecord testRecord);
    long getCount();
}
