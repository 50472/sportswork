package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.entity.FieldLease;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:21
 * @description
 */
public interface IFieldLeaseService {
    void addFieldLease(FieldLease fieldLease);
    FieldLease getFieldLease(String id);
    List<FieldLease> getAllFieldLeases();
    void deleteFieldLease(String id);
    void setFieldLease(FieldLease fieldLease);
    long getCount();
}
