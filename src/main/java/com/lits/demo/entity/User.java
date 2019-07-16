package com.lits.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
//@Data
@Setter
@Getter
public class User {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "id", unique = true, nullable = false)
        private Long id;

        @Column(name = "username", unique = true)
        private String username;

        @Column(name = "password")
        private String password;

        @Column(name = "role")
        private String role;

        public User() {
        }

        public User(String username, String password) {
                this.username = username;
                this.password = password;
        }
}
