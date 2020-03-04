package com.sportswork.sportswork.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author dengwei
 * @date 2020/2/27 22:43
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserRole {
    private String id;
    private String userId;
    private String roleId;
}
