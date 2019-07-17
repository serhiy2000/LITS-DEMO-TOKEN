package com.lits.demo.repository;

import com.lits.demo.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDataRepository extends CrudRepository<Person, Integer> {
    Person findOneById(Integer id);
    Person findOneByPersonName (String personName);
    List<Person> findByNameAndCar (String name, String car);
}
