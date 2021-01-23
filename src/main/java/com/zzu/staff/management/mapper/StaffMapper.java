package com.zzu.staff.management.mapper;

import com.zzu.staff.management.entity.SchoolType;
import com.zzu.staff.management.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {
    List<Staff> queryAll();

    Staff queryById(long id);

    int insert(Staff staff);

    int deleteById(long id);

    int update(Staff  staff);
}
