package com.sportswork.sportswork.core.entity;

import com.sportswork.sportswork.core.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author dengwei
 * @date 2020/1/9 13:30
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SportsTest extends BaseEntity {
    public String getId(){
        return this.id;
    }

    private String name;
    private String passMark;
}
