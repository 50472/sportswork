package com.sportswork.sportswork.core.service;

import com.sportswork.sportswork.core.entity.Field;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:18
 * @description
 */
public interface IFieldService {
    void addField(Field field);
    Field getField(String id);
    List<Field> getFieldByNameLike(String name);
    List<Field> getAllFields();
    void deleteField(String id);
    void setField(Field field);
    long getCount();
}
