package com.zzu.staff.management.mapper;

import com.zzu.staff.management.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolMapper {

    List<School> queryAll();
}
