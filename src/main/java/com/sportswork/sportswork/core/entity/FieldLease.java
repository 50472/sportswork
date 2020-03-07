package com.sportswork.sportswork.core.entity;

import com.sportswork.sportswork.core.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dengwei
 * @date 2020/1/9 14:29
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FieldLease extends BaseEntity {
    public String getId(){
        return this.id;
    }

    private String studentId;
    private String fieldId;
    private Long borrowTime;    //开始借用时间 使用时间戳 单位(微秒)
    private double lendingTime;     //借用时长 单位(小时)
//    private Long expirationTime;   //到期借用时间 使用时间戳 单位(微秒)
    private int expire;    //到期标志：0表示未到期，1表示已到期

    private Student student;
    private Field field;

//    private String borrowTimeDate;
//    private String expirationTimeDate;

    public Long getExpirationTime(){
        return borrowTime + lendingToTimeStamp();
    }

    public Long lendingToTimeStamp(){
        return new Double(lendingTime * 60 * 60 * 1000).longValue();
    }

    public String timeToString(Long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        return simpleDateFormat.format(new Date(time));
    }

    public String getBorrowTimeDate(){
        return timeToString(borrowTime);
    }

    public String getExpirationTimeDate(){
        return timeToString(getExpirationTime());
    }
}
