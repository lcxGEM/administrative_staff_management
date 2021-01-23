package com.zzu.staff.management.service.impl;

import com.zzu.staff.management.entity.Staff;
import com.zzu.staff.management.mapper.StaffMapper;
import com.zzu.staff.management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> queryAll() {
        return staffMapper.queryAll();
    }

    @Override
    public Staff queryById(long id) {
        return staffMapper.queryById(id);
    }

    @Override
    public int insert(Staff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public int deleteById(long id) {
        return staffMapper.deleteById(id);
    }

    @Override
    public int update(Staff staff) {
        return staffMapper.update(staff);
    }
}
