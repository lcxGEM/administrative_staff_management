package com.zzu.staff.management.service;

import com.zzu.staff.management.entity.Staff;
import com.zzu.staff.management.entity.StaffVo;

import java.util.List;

public interface StaffService {

    List<Staff> queryAll();

    List<StaffVo> queryAllVo(String sName,int teacherType, int gsType, int msType, int dsType,int depart,int status,int stId);

    Staff queryById(long id);

    int insert(Staff staff);

    int deleteById(long id);

    int update(Staff  staff);

    int staffAdd(Staff staff);

    int changeStatus(long id, int status);

    int updateAll(int stId);
}
