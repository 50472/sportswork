package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Equipment;
import com.sportswork.sportswork.core.mapper.EquipmentMapper;
import com.sportswork.sportswork.core.service.IElectiveService;
import com.sportswork.sportswork.core.service.IEquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:25
 * @description
 */
@Slf4j
@Service
@Transactional
public class EquipmentServiceImp implements IEquipmentService {
    @Resource
    private EquipmentMapper equipmentMapper;

    @Override
    public void addEquipment(Equipment equipment) {
        equipment.setLend(0);
        equipmentMapper.addEquipment(equipment);
    }

    @Override
    public Equipment getEquipment(String id) {
        return equipmentMapper.getEquipment(id);
    }

    @Override
    public List<Equipment> getEquipmentByNameLike(String name) {
        return equipmentMapper.getEquipmentByNameLike(name);
    }

    @Override
    public List<Equipment> getAllEquipments() {
        return equipmentMapper.getAllEquipments();
    }

    @Override
    public void deleteEquipment(String id) {
        equipmentMapper.deleteEquipment(id);
    }

    @Override
    public void setEquipment(Equipment equipment) {
        equipmentMapper.setEquipment(equipment);
    }

    @Override
    public long getCount() {
        return equipmentMapper.getCount();
    }
}
