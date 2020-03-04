package com.sportswork.sportswork.core.mapper;

import com.sportswork.sportswork.core.entity.Field;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 17:31
 * @description
 */
public interface FieldMapper {
    void addField(Field field);
    Field getField(String id);
    List<Field> getAllFields();
    void deleteField(String id);
    void setField(Field field);
    long getCount();
}
