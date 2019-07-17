package com.lits.demo.repository;

import com.lits.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<User, Integer> {
    User findOneByUsername (String username);
}
