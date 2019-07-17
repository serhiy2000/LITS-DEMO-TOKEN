package com.lits.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "person")
//@ToString(exclude = {"id" , "age" , "dead"}) // for lombok
//@EqualsAndHashCode(exclude = {"id"}) // for lombok
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

    private String car;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "city")
    private Set<City> cities;
}
