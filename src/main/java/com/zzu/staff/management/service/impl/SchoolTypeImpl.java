package com.zzu.staff.management.service.impl;

import com.zzu.staff.management.entity.SchoolType;
import com.zzu.staff.management.mapper.SchoolTypeMapper;
import com.zzu.staff.management.service.SchoolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolTypeImpl implements SchoolTypeService {

    @Autowired
    private SchoolTypeMapper schoolTypeMapper;

    @Override
    public List<SchoolType> queryAll() {
        return schoolTypeMapper.queryAll();
    }

    @Override
    public SchoolType queryById(int id) {
        return schoolTypeMapper.queryById(id);
    }

    @Override
    public int insert(SchoolType schoolType) {
        return schoolTypeMapper.insert(schoolType);
    }

    @Override
    public int deleteById(int id) {
        return schoolTypeMapper.deleteById(id);
    }

    @Override
    public int update(SchoolType schoolType) {
        return schoolTypeMapper.update(schoolType);
    }
}
