package com.lits.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//@Data
@Getter
@Setter
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    Integer Id;

    String city;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "person_id")
    private Person person;
}
