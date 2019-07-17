package com.lits.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
//@Data
@Setter
@Getter
public class User {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        private Long id;

        @Column(name = "username")
        private String username;

        @Column(name = "password")
        private String password;

        @Column(name = "role")
//        @NotEmpty(message = "Role cannot be emplty")
        private String role;

        public User() {}

        public User(String username, String password) {
                this.username = username;
                this.password = password;
        }
}
