package com.lits.demo.dtos;

import lombok.*;

//@Data
@Setter
@Getter
public class PersonDto {
    private Integer Id;
    private String personName;
    private Integer age;
    private boolean dead;
}
