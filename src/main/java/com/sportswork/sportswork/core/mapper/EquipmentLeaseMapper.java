package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.EquipmentLease;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 17:31
 * @description
 */
public interface EquipmentLeaseMapper {
    void addEquipmentLease(EquipmentLease equipmentLease);
    EquipmentLease getEquipmentLease(String id);
    List<EquipmentLease> getEquipmentLeaseByEquipmentNameOrStudentNumber(String equipmentName, String studentNumber);
    List<EquipmentLease> getAllEquipmentLeases();
    void deleteEquipmentLease(String id);
    void setEquipmentLease(EquipmentLease equipmentLease);
    void setReturn(EquipmentLease equipmentLease);
    long getCount();
}
