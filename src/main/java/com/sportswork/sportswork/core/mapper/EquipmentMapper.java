package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Equipment;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 17:31
 * @description
 */
public interface EquipmentMapper {
    void addEquipment(Equipment equipment);
    Equipment getEquipment(String id);
    List<Equipment> getEquipmentByNameLike(String _parameter);
    List<Equipment> getAllEquipments();
    void deleteEquipment(String id);
    void setEquipment(Equipment equipment);
    void setEquipmentLend(Equipment equipment);
    long getCount();
}
