package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.FieldLease;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 17:32
 * @description
 */
public interface FieldLeaseMapper {
    void addFieldLease(FieldLease fieldLease);
    FieldLease getFieldLease(String id);
    List<FieldLease> getFieldLeaseByFieldNameLikeOrStudentNumber(String fieldName, String studentNumber);
    List<FieldLease> getAllFieldLeases();
    void deleteFieldLease(String id);
    void setFieldLease(FieldLease fieldLease);
    long getCount();
}
