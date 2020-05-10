package com.sportswork.sportswork.core.entity;

import com.sportswork.sportswork.core.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author dengwei
 * @date 2020/1/9 14:30
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Teaching extends BaseEntity {

    public String getId(){
        return this.id;
    }
    public Teaching setId(String id){
        this.id = id;
        return this;
    }

    private String teacherId;
    private String courseId;
    private Teacher teacher;
    private Course course;
    private String semester;
    private int state;
    private int week;   //星期
    private int timeArrange;   //节课时间安排
    private Field field;   //安排场地

    public boolean getStateBoolean(){
        return state == 0;
    }
}
