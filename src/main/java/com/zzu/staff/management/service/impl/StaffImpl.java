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
    public List<StaffVo> queryAllVo(String sName,int teacherType, int gsType, int msType, int dsType,int depart,int status,int stId) {
        String trim = sName.trim();
        if(stId==0){//顶级管理员
            if(trim.length()==0&&teacherType==-1&&gsType==0&&msType==0&&dsType==0&&depart==-1&&status==-1){
                return staffMapper.queryAllVo();
            }else {
                return staffMapper.searchAllVo(trim,teacherType,gsType,msType,dsType,depart,status);
            }
        }else{
            if(trim.length()==0&&teacherType==-1&&gsType==0&&msType==0&&dsType==0&&depart==-1&&status==-1){
                return staffMapper.queryAllVoByDepart(stId);
            }else {
                return staffMapper.searchAllVoByDepart(trim,teacherType,gsType,msType,dsType,depart,status,stId);
            }
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

    @Override
    public int changeStatus(long id, int status) {
        return staffMapper.changeStatus(id,status);
    }

    @Override
    public int updateAll(int stId) {
        int a=0;
        if(stId!=0){
            return -1;
        }else{
            List<Staff> staffList = staffMapper.queryAll();
            for (Staff staff:staffList){
                staff = setCompositeIndexAndEvaluation(staff);
                a+=staffMapper.update(staff);
            }
            return a;
        }
    }

    private Staff setCompositeIndexAndEvaluation(Staff staff){
        float masterIndex = 1f;   //硕士基准值
        float underIndex = 1f;
        float doctorIndex = 1f;
        Float basicIndex = 1f;
        if(staff.getTeacherType()==0){//原值
            if(staff.getMasterSchool()!=0){
                School masterSchool = schoolMapper.queryById(staff.getMasterSchool());//硕士学校
                masterIndex = schoolTypeMapper.queryById(masterSchool.getSchoolType()).getMasterIndex(); //硕士基准值
            }
            if(staff.getUndergraduateSchool()!=0){
                School underSchool = schoolMapper.queryById(staff.getUndergraduateSchool());//学士
                underIndex = schoolTypeMapper.queryById(underSchool.getSchoolType()).getUndergraduateIndex(); //学士基准值
            }
            if(staff.getDoctorSchool()!=0){
                School doctorSchool = schoolMapper.queryById(staff.getDoctorSchool());//博士
                doctorIndex = schoolTypeMapper.queryById(doctorSchool.getSchoolType()).getDoctorIndex(); //博士基准值
            }
            //queryByName("基准值")
            SchoolType schoolType=schoolTypeMapper.queryByName("基准值");
            basicIndex = schoolType.getSumIndex(); //基准值
        }else{//新值
            if(staff.getMasterSchool()!=0){
                School masterSchool = schoolMapper.queryById(staff.getMasterSchool());//硕士学校
                masterIndex = schoolTypeMapper.queryById(masterSchool.getSchoolType()).getAmasterIndex(); //硕士基准值
            }
            if(staff.getUndergraduateSchool()!=0){
                School underSchool = schoolMapper.queryById(staff.getUndergraduateSchool());//学士
                underIndex = schoolTypeMapper.queryById(underSchool.getSchoolType()).getAundergraduateIndex(); //学士基准值
            }
            if(staff.getDoctorSchool()!=0){
                School doctorSchool = schoolMapper.queryById(staff.getDoctorSchool());//博士
                doctorIndex = schoolTypeMapper.queryById(doctorSchool.getSchoolType()).getAdoctorIndex(); //博士基准值
            }
            //queryByName("基准值")
            SchoolType schoolType=schoolTypeMapper.queryById(40);
            basicIndex = schoolType.getAsumIndex(); //基准值
        }
        Float compositeIndex = 75f*underIndex*masterIndex*doctorIndex/basicIndex;
        System.out.println("------------------------------------>75*"+underIndex+"*"+masterIndex+"*"+doctorIndex+"/"+basicIndex+"="+compositeIndex);
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
