package com.sportswork.sportswork.mapper;

import com.sportswork.sportswork.core.entity.Equipment;
import com.sportswork.sportswork.core.mapper.EquipmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 18:13
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipmentMapperTest {
    @Resource
    private EquipmentMapper equipmentMapper;

    @Test
    @Transactional
    public void getAllEquipments() throws Exception {
        List<Equipment> equipmentList = equipmentMapper.getAllEquipments();
        System.out.println(equipmentList.toString());
    }
}
