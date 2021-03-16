package com.zzu.staff.management.entity;

public enum StaffStatus {

    A("新申请",0),B("院系通过",1),C("学校通过",2),
    D("成功入职",3),E("院系不通过",4),F("学校不通过",5);

    private final String status;
    private final int staffStatus;

    StaffStatus(String status,int staffStatus){
        this.status = status;
        this.staffStatus = staffStatus;
    }

    public static String getStatus(int staffStatus){
        for (StaffStatus status:StaffStatus.values()) {
            if(status.getIndex()==staffStatus){
                return status.status;
            }
        }
        return "未选中类型";
    }

    private int getIndex(){
        return staffStatus;
    }

}
