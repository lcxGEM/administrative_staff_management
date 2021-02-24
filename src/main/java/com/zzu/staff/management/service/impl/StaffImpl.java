package com.zzu.staff.management.service.impl;

import com.zzu.staff.management.entity.School;
import com.zzu.staff.management.entity.SchoolType;
import com.zzu.staff.management.entity.Staff;
import com.zzu.staff.management.entity.StaffVo;
import com.zzu.staff.management.mapper.SchoolMapper;
import com.zzu.staff.management.mapper.SchoolTypeMapper;
import com.zzu.staff.management.mapper.StaffMapper;
import com.zzu.staff.management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private SchoolTypeMapper schoolTypeMapper;

    @Override
    public List<Staff> queryAll() {
        return staffMapper.queryAll();
    }

    @Override
    public List<StaffVo> queryAllVo(String sName, Integer gsType, Integer msType, Integer dsType) {
        String trim = sName.trim();
        if(trim.length()==0&&gsType==0&&msType==0&&dsType==0){
            return staffMapper.queryAllVo();
        }else {
            return staffMapper.searchAllVo(trim,gsType,msType,dsType);
        }
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
        staff = setCompositeIndexAndEvaluation(staff);
        return staffMapper.update(staff);
    }

    @Override
    public int staffAdd(Staff staff) {
        staff = setCompositeIndexAndEvaluation(staff);
        try{
            return staffMapper.insert(staff);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    private Staff setCompositeIndexAndEvaluation(Staff staff){
        float masterIndex = 1f;   //硕士基准值
        if(staff.getMasterSchool()!=0){
            School masterSchool = schoolMapper.queryById(staff.getMasterSchool());//硕士学校
            masterIndex = schoolTypeMapper.queryById(masterSchool.getSchoolType()).getMasterIndex(); //硕士基准值
        }
        float underIndex = 1f;
        if(staff.getUndergraduateSchool()!=0){
            School underSchool = schoolMapper.queryById(staff.getUndergraduateSchool());//学士
            underIndex = schoolTypeMapper.queryById(underSchool.getSchoolType()).getUndergraduateIndex(); //学士基准值
        }
        float doctorIndex = 1f;
        if(staff.getDoctorSchool()!=0){
            School doctorSchool = schoolMapper.queryById(staff.getDoctorSchool());//博士
            doctorIndex = schoolTypeMapper.queryById(doctorSchool.getSchoolType()).getDoctorIndex(); //博士基准值
        }

        //queryByName("基准值")
        SchoolType schoolType=schoolTypeMapper.queryById(40);
        Float basicIndex = schoolType.getSumIndex(); //基准值
        Float compositeIndex = 75f*underIndex*masterIndex*doctorIndex/basicIndex;
        if(compositeIndex>100){
            compositeIndex = 100f;
        }
        staff.setCompositeIndex(compositeIndex);
        if(compositeIndex>=80){
            staff.setEvaluation("优");
        }else if(compositeIndex>=70){
            staff.setEvaluation(("良"));
        }else if(compositeIndex>=60){
            staff.setEvaluation("中");
        }else {
            staff.setEvaluation("差");
        }
        return staff;
    }
}
