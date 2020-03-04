package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.EquipmentLease;
import com.sportswork.sportswork.core.mapper.EquipmentLeaseMapper;
import com.sportswork.sportswork.core.service.IEquipmentLeaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:29
 * @description
 */
@Slf4j
@Service
@Transactional
public class EquipmentLeaseServiceImp implements IEquipmentLeaseService {
    @Resource
    private EquipmentLeaseMapper equipmentLeaseMapper;

    @Override
    public void addEquipmentLease(EquipmentLease equipmentLease) {
        equipmentLeaseMapper.addEquipmentLease(equipmentLease);
    }

    @Override
    public EquipmentLease getEquipmentLease(String id) {
        return equipmentLeaseMapper.getEquipmentLease(id);
    }

    @Override
    public List<EquipmentLease> getAllEquipmentLeases() {
        return equipmentLeaseMapper.getAllEquipmentLeases();
    }

    @Override
    public void deleteEquipmentLease(String id) {
        equipmentLeaseMapper.deleteEquipmentLease(id);
    }

    @Override
    public void setEquipmentLease(EquipmentLease equipmentLease) {
        equipmentLeaseMapper.setEquipmentLease(equipmentLease);
    }

    @Override
    public long getCount() {
        return equipmentLeaseMapper.getCount();
    }
}
