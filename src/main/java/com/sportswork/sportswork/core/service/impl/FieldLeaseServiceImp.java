package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.FieldLease;
import com.sportswork.sportswork.core.mapper.FieldLeaseMapper;
import com.sportswork.sportswork.core.mapper.FieldMapper;
import com.sportswork.sportswork.core.mapper.StudentMapper;
import com.sportswork.sportswork.core.service.IFieldLeaseService;
import com.sportswork.sportswork.core.service.dto.FieldLeaseDTO;
import com.sportswork.sportswork.core.service.tool.MyTimerTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private FieldMapper fieldMapper;

    @Override
    public void addFieldLease(FieldLeaseDTO fieldLeaseDTO) {
        Long time = System.currentTimeMillis();
        FieldLease fieldLease = new FieldLease().setBorrowTime(time)
                .setExpire(0)
                .setLendingTime(fieldLeaseDTO.getLendingTime())
                .setFieldId(fieldLeaseDTO.getFieldId())
                .setStudentId(studentMapper.getStudentByNumber(
                        fieldLeaseDTO.getStudentNumber()).getId());
        fieldLeaseMapper.addFieldLease(fieldLease);
        fieldMapper.setFieldState(fieldLeaseDTO.getFieldId(), 1);

        MyTimerTask timerTask = new MyTimerTask().setFieldLease(fieldLease.setExpire(1))
                .setFieldId(fieldLeaseDTO.getFieldId())
                .setFieldLeaseMapper(fieldLeaseMapper)
                .setFieldMapper(fieldMapper);
        Timer timer = new Timer();
        timer.schedule(timerTask,fieldLease.lendingToTimeStamp());         //第二参数为多少时间后（1000为1秒）
    }

    @Override
    public FieldLease getFieldLease(String id) {
        return fieldLeaseMapper.getFieldLease(id);
    }

    @Override
    public List<FieldLease> getFieldLeaseByFieldNameLikeOrStudentNumber(String fieldName, String studentNumber) {
        return fieldLeaseMapper.getFieldLeaseByFieldNameLikeOrStudentNumber(fieldName, studentNumber);
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
