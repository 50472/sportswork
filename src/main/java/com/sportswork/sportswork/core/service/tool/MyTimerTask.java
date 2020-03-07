package com.sportswork.sportswork.core.service.tool;

import com.sportswork.sportswork.core.entity.Field;
import com.sportswork.sportswork.core.entity.FieldLease;
import com.sportswork.sportswork.core.mapper.FieldLeaseMapper;
import com.sportswork.sportswork.core.mapper.FieldMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.TimerTask;

/**
 * @author dengwei
 * @date 2020/3/5 21:38
 * @description
 */
@Slf4j
@Service
@Transactional
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class MyTimerTask extends TimerTask {
    private FieldLease fieldLease;
    private String fieldId;
    private FieldLeaseMapper fieldLeaseMapper;
    private FieldMapper fieldMapper;

    @Override
    public void run(){
        fieldLeaseMapper.setFieldLease(fieldLease);
        fieldMapper.setFieldState(fieldId, 0);
    }

    public MyTimerTask setFieldLease(FieldLease fieldLease) {
        this.fieldLease = fieldLease;
        return this;
    }

    public MyTimerTask setFieldId(String fieldId) {
        this.fieldId = fieldId;
        return this;
    }

    public MyTimerTask setFieldLeaseMapper(FieldLeaseMapper fieldLeaseMapper) {
        this.fieldLeaseMapper = fieldLeaseMapper;
        return this;
    }

    public MyTimerTask setFieldMapper(FieldMapper fieldMapper) {
        this.fieldMapper = fieldMapper;
        return this;
    }
}
