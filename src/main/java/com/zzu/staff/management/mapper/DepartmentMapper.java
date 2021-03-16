package com.zzu.staff.management.mapper;

import com.zzu.staff.management.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> queryAll();
}
