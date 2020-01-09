package com.sportswork.sportswork.core.entity;

import com.sportswork.sportswork.core.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dengwei
 * @date 2020/1/9 14:30
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teaching extends BaseEntity {
    private String teacherId;
    private String courseId;
    private String semester;
    private String state;
}
