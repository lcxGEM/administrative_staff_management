package com.zzu.staff.management.entity;

public enum TeacherType {

    A("青年教师",0),B("专职科研/求是博士后",1),C("博士后",2),D("其他",3);

    private final String name;
    private final int index;
    TeacherType(String name,int index){
        this.name = name;
        this.index = index;
    }

    public static String getTeacherType(int index){
        for (TeacherType t:TeacherType.values()) {
            if(t.getIndex()==index){
                return t.name;
            }
        }
        return "未选中类型";
    }

    private int getIndex(){
        return index;
    }
}
