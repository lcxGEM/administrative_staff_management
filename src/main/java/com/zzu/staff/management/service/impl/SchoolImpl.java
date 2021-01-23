package com.zzu.staff.management.service.impl;

import com.zzu.staff.management.entity.School;
import com.zzu.staff.management.mapper.SchoolMapper;
import com.zzu.staff.management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<School> queryAll() {
        return schoolMapper.queryAll();
    }

    @Override
    public School queryById(long id) {
        return schoolMapper.queryById(id);
    }

    @Override
    public int insert(School school) {
        return schoolMapper.insert(school);
    }

    @Override
    public int deleteById(long id) {
        return schoolMapper.deleteById(id);
    }

    @Override
    public int update(School school) {
        return schoolMapper.update(school);
    }
}
