package com.zzu.staff.management.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StaffVo implements Serializable {

    private Long id;

    private Integer teacherType; //教师类型

    private String name;

    private String identity;

    private Integer sex;

    private String tel;

    private Date birthday;

    private Long undergraduateSchool;

    private Long masterSchool;

    private Long doctorSchool;

    private String uSchoolName;

    private String mSchoolName;

    private String dSchoolName;

    private Float compositeIndex;

    private String evaluation; //评价

    private String departmentName;

    private Integer department;

    private Integer status;

    public Long getUndergraduateSchool() {
        if(undergraduateSchool!=null){
            return this.undergraduateSchool;
        }else{
            return new Long(0);
        }
    }

    public Long getMasterSchool() {
        if(masterSchool!=null){
            return this.masterSchool;
        }else {
            return new Long(0);
        }
    }

    public Long getDoctorSchool() {
        if(doctorSchool!=null) {
            return this.doctorSchool;
        }else {
            return new Long(0);
        }
    }

    public String getuSchoolName() {
        return uSchoolName!=null? uSchoolName:"无";
    }

    public String getmSchoolName() {
        return mSchoolName!=null?mSchoolName:"无";
    }

    public String getdSchoolName() {
        return dSchoolName!=null?dSchoolName:"无";
    }

    public String getTeacherType() {
        return TeacherType.getTeacherType(teacherType);
    }
}
