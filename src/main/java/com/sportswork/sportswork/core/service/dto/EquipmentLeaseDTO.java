package com.sportswork.sportswork.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author dengwei
 * @date 2020/3/6 15:00
 * @description
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class EquipmentLeaseDTO {
    private String studentNumber;
    private String equipmentId;
    private int number;
}
