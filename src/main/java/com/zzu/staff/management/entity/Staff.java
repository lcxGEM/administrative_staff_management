package com.zzu.staff.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

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

    private Float compositeIndex;

    private String evaluation; //评价
}
