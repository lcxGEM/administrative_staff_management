package com.zzu.staff.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School  implements Serializable {

    private Long id;

    private String name;

    private Integer schoolType;

    private Integer sort;
}
