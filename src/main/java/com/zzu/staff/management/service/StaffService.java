package com.zzu.staff.management.service;

import com.zzu.staff.management.entity.Staff;
import com.zzu.staff.management.entity.StaffVo;

import java.util.List;

public interface StaffService {

    List<Staff> queryAll();

    List<StaffVo> queryAllVo();

    Staff queryById(long id);

    int insert(Staff staff);

    int deleteById(long id);

    int update(Staff  staff);
}
