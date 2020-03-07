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
public class EquipmentLease extends BaseEntity {
    public String getId(){
        return this.id;
    }

    private String studentId;
    private String equipmentId;
    private int number;
    private int state;     //借用状态：0表示未归还，1表示已归还
    private Long borrowTime;
    private Long returnTime;

    private Student student;
    private Equipment equipment;

    public String timeToString(Long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        return simpleDateFormat.format(new Date(time));
    }

    public String getBorrowTimeDate(){
        return timeToString(borrowTime);
    }

    public String getReturnTimeDate(){
        if(returnTime == null){
            return "--:--:--";
        }else{
            return timeToString(returnTime);
        }

    }

    public String getLendingTimeDate(){
        if(returnTime == null){
            return "--:--:--";
        }else{
            Long hour = (returnTime - borrowTime)/(60*60*1000);
            Long minute = ((returnTime - borrowTime)%(60*60*1000))/(60*1000);
            Long second = (((returnTime - borrowTime)%(60*60*1000))/(60*1000))/(1000);
            return hour +"时" +minute + "分" + second + "秒";
        }

    }
}
