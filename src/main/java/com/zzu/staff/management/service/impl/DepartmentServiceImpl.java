package com.zzu.staff.management.service.impl;

import com.zzu.staff.management.entity.Department;
import com.zzu.staff.management.mapper.DepartmentMapper;
import com.zzu.staff.management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> queryAll() {
        return departmentMapper.queryAll();
    }
}
