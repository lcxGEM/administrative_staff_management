package com.zzu.staff.management.mapper;

import com.zzu.staff.management.entity.School;
import com.zzu.staff.management.entity.SchoolVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolMapper {

    List<School> queryAll();

    List<SchoolVo> queryAllVo();

    School queryById(long id);

    int insert(School school);

    int deleteById(long id);

    int deleteByType(int type);

    int update(School school);

    List<SchoolVo> searchAllVo(String sName, @Param("sType") Integer sType);
}
