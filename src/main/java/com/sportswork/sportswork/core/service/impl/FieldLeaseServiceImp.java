package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.FieldLease;
import com.sportswork.sportswork.core.mapper.FieldLeaseMapper;
import com.sportswork.sportswork.core.service.IFieldLeaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:21
 * @description
 */
@Slf4j
@Service
@Transactional
public class FieldLeaseServiceImp implements IFieldLeaseService {
    @Resource
    private FieldLeaseMapper fieldLeaseMapper;

    @Override
    public void addFieldLease(FieldLease fieldLease) {
        fieldLeaseMapper.addFieldLease(fieldLease);
    }

    @Override
    public FieldLease getFieldLease(String id) {
        return fieldLeaseMapper.getFieldLease(id);
    }

    @Override
    public List<FieldLease> getAllFieldLeases() {
        return fieldLeaseMapper.getAllFieldLeases();
    }

    @Override
    public void deleteFieldLease(String id) {
        fieldLeaseMapper.deleteFieldLease(id);
    }

    @Override
    public void setFieldLease(FieldLease fieldLease) {
        fieldLeaseMapper.setFieldLease(fieldLease);
    }

    @Override
    public long getCount() {
        return fieldLeaseMapper.getCount();
    }
}
