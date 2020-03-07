package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.entity.Equipment;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:24
 * @description
 */
public interface IEquipmentService {
    void addEquipment(Equipment equipment);
    Equipment getEquipment(String id);
    List<Equipment> getEquipmentByNameLike(String name);
    List<Equipment> getAllEquipments();
    void deleteEquipment(String id);
    void setEquipment(Equipment equipment);
    long getCount();
}
