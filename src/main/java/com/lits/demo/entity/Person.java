package com.lits.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table (name = "person")
//@ToString(exclude = {"id" , "age" , "dead"})
//@EqualsAndHashCode(exclude = {"id"})
@Setter
@Getter
//@Data
//@Builder - цей елеметент ломбоку створює пустий конструктор
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String personName;
    private Integer age;
    private boolean dead;
}
