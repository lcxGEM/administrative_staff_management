package com.zzu.staff.management.entity;

import lombok.Data;

public class StaffVo {

    private Long id;

    private String name;

    private String tel;

    private Long undergraduateSchool;

    private Long masterSchool;

    private Long doctorSchool;

    private String uSchoolName;

    private Long uSchoolIndex;

    private String mSchoolName;

    private Long mSchoolIndex;

    private String dSchoolName;

    private Long dSchoolIndex;

    private Float compositeIndex;

    private Integer status;

    public void setUndergraduateSchool(Long undergraduateSchool) {
        if(undergraduateSchool!=null){
            this.undergraduateSchool = undergraduateSchool;
        }else{
            this.undergraduateSchool = new Long(0);
        }
    }

    public void setMasterSchool(Long masterSchool) {
        if(masterSchool!=null){
            this.masterSchool = masterSchool;
        }else {
            this.masterSchool = new Long(0);
        }
    }

    public void setDoctorSchool(Long doctorSchool) {
        if(doctorSchool!=null) {
            this.doctorSchool = doctorSchool;
        }else {
            this.doctorSchool = new Long(0);
        }
    }

    public void setmSchoolName(String mSchoolName) {
        if(mSchoolName!=null&&!mSchoolName.equals("")){
            this.mSchoolName = mSchoolName;
        }else{
            this.mSchoolName = "无";
        }
    }

    public void setmSchoolIndex(Long mSchoolIndex) {
        if(mSchoolIndex!=null) {
            this.mSchoolIndex = mSchoolIndex;
        }else{
            this.mSchoolIndex = new Long(1);
        }
    }
    public void setdSchoolName(String dSchoolName) {
        if(dSchoolName!=null&&!dSchoolName.equals("")){
            this.dSchoolName = dSchoolName;
        }else{
            this.dSchoolName = "无";
        }
    }

    public void setdSchoolIndex(Long dSchoolIndex) {
        if(dSchoolIndex!=null) {
            this.dSchoolIndex = dSchoolIndex;
        }else{
            this.dSchoolIndex = new Long(1);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getUndergraduateSchool() {
        return undergraduateSchool;
    }

    public Long getMasterSchool() {
        return masterSchool;
    }

    public Long getDoctorSchool() {
        return doctorSchool;
    }

    public String getuSchoolName() {
        return uSchoolName;
    }

    public void setuSchoolName(String uSchoolName) {
        this.uSchoolName = uSchoolName;
    }

    public Long getuSchoolIndex() {
        return uSchoolIndex;
    }

    public void setuSchoolIndex(Long uSchoolIndex) {
        this.uSchoolIndex = uSchoolIndex;
    }

    public String getmSchoolName() {
        return mSchoolName;
    }

    public Long getmSchoolIndex() {
        return mSchoolIndex;
    }

    public String getdSchoolName() {
        return dSchoolName;
    }

    public Long getdSchoolIndex() {
        return dSchoolIndex;
    }

    public Float getCompositeIndex() {
        return compositeIndex;
    }

    public void setCompositeIndex(Float compositeIndex) {
        this.compositeIndex = compositeIndex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
