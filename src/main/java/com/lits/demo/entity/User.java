package com.lits.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
//@Data
@Setter
@Getter
public class User {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String password;
        private String role;
}
