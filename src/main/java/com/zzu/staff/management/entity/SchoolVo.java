package com.zzu.staff.management.entity;

import lombok.Data;

@Data
public class SchoolVo {

    private Long id;

    private String name;

    private String region;

    private Integer schoolType;

    private String typeName;
}