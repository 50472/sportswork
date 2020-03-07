package com.sportswork.sportswork.core.service.impl;

import com.sportswork.sportswork.core.entity.Equipment;
import com.sportswork.sportswork.core.entity.EquipmentLease;
import com.sportswork.sportswork.core.entity.FieldLease;
import com.sportswork.sportswork.core.entity.Student;
import com.sportswork.sportswork.core.mapper.EquipmentLeaseMapper;
import com.sportswork.sportswork.core.mapper.EquipmentMapper;
import com.sportswork.sportswork.core.mapper.StudentMapper;
import com.sportswork.sportswork.core.service.IEquipmentLeaseService;
import com.sportswork.sportswork.core.service.dto.EquipmentLeaseDTO;
import com.sportswork.sportswork.core.service.tool.MyTimerTask;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Timer;

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
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private EquipmentMapper equipmentMapper;

    @Override
    public void addEquipmentLease(EquipmentLeaseDTO equipmentLeaseDTO) {
        Equipment equipment = equipmentMapper.getEquipment(equipmentLeaseDTO.getEquipmentId());
        if(equipment.getCount() - equipment.getLend() < equipmentLeaseDTO.getNumber()){
            throw new RuntimeException("器材数量不足");
        }else{
            Long time = System.currentTimeMillis();
            EquipmentLease equipmentLease = new EquipmentLease().setBorrowTime(time)
                    .setState(0)
                    .setNumber(equipmentLeaseDTO.getNumber())
                    .setEquipmentId(equipmentLeaseDTO.getEquipmentId())
                    .setStudentId(studentMapper.getStudentByNumber(
                            equipmentLeaseDTO.getStudentNumber()).getId());
            equipment.setLend(equipment.getLend() + equipmentLeaseDTO.getNumber());
            equipmentLeaseMapper.addEquipmentLease(equipmentLease);
            equipmentMapper.setEquipmentLend(equipment);
        }
    }

    @Override
    public void returnEquipment(String equipmentLeaseId) {
        EquipmentLease equipmentLease = equipmentLeaseMapper.getEquipmentLease(equipmentLeaseId)
                .setReturnTime(System.currentTimeMillis())
                .setState(1);
        Equipment equipment = equipmentMapper.getEquipment(equipmentLease.getEquipmentId());
        equipmentMapper.setEquipmentLend(equipment.setLend(equipment.getLend() - equipmentLease.getNumber()));
        equipmentLeaseMapper.setReturn(equipmentLease);
    }

    @Override
    public EquipmentLease getEquipmentLease(String id) {
        return equipmentLeaseMapper.getEquipmentLease(id);
    }

    @Override
    public List<EquipmentLease> getEquipmentLeaseByEquipmentNameOrStudentNumber(String equipmentName, String studentNumber) {
        return equipmentLeaseMapper.getEquipmentLeaseByEquipmentNameOrStudentNumber(equipmentName, studentNumber);
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
