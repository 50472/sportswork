package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.entity.EquipmentLease;
import com.sportswork.sportswork.core.service.dto.EquipmentLeaseDTO;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:28
 * @description
 */
public interface IEquipmentLeaseService {
    void addEquipmentLease(EquipmentLeaseDTO equipmentLeaseDTO);
    void returnEquipment(String equipmentLeaseId);
    EquipmentLease getEquipmentLease(String id);
    List<EquipmentLease> getEquipmentLeaseByEquipmentNameOrStudentNumber(String equipmentName, String studentNumber);
    List<EquipmentLease> getAllEquipmentLeases();
    void deleteEquipmentLease(String id);
    void setEquipmentLease(EquipmentLease equipmentLease);
    long getCount();
}
