package com.zzu.staff.management.mapper;

import com.zzu.staff.management.entity.SchoolType;
import com.zzu.staff.management.entity.Staff;
import com.zzu.staff.management.entity.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {
    List<Staff> queryAll();

    List<StaffVo> queryAllVo();

    Staff queryById(long id);

    int insert(Staff staff);

    int deleteById(long id);

    int update(Staff  staff);

    List<StaffVo> searchAllVo(String trim,
                              @Param("teacherType")int teacherType,
                              @Param("gsType")Integer gsType,
                              @Param("msType")int msType,
                              @Param("dsType")int dsType,
                              @Param("depart")int depart,
                              @Param("status")int status);

    List<StaffVo> queryAllVoByDepart(int stId);

    List<StaffVo> searchAllVoByDepart(String trim,
                                      @Param("teacherType")int teacherType,
                                      @Param("gsType")Integer gsType,
                                      @Param("msType")int msType,
                                      @Param("dsType")int dsType,
                                      @Param("depart")int depart,
                                      @Param("status")int status,
                                      @Param("stId") int stId);

    int changeStatus(@Param("id") long id, @Param("status") int status);
}
