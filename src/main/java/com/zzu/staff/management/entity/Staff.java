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

    private String name;

    private Integer sex;

    private String tel;

    private Integer age;

    private Date birthday;

    private Long undergraduateSchool;

    private Long masterSchool;

    private Long doctorSchool;

    private Float compositeIndex;
}
