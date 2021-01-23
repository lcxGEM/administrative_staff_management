package com.zzu.staff.management.mapper;

import com.zzu.staff.management.entity.SchoolType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolTypeMapper {
    List<SchoolType> queryAll();

    SchoolType queryById(int id);

    int insert(SchoolType schoolType);

    int deleteById(int id);

    int update(SchoolType schoolType);
}
