package com.zzu.staff.management.entity;

import lombok.Data;

@Data
public class Manager {

    private Integer id;

    private String name;

    private String passwd;

    private int department;

    private String departmentName;
}
