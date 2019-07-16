package com.lits.demo.repository;

import com.lits.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<User, Integer> {

    User findOneByUsername (String username);

}
