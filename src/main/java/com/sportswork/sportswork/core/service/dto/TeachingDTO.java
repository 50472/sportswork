package com.sportswork.sportswork.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author dengwei
 * @date 2020/3/4 19:11
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TeachingDTO {
    private String id;
    private String teacherNumber;
    private String courseNumber;
    private String semester;
    private int week;
    private int timeArrange;
    private int state;
}
