package com.lits.demo.repository;

import com.lits.demo.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository <City, Integer> {
    City findOneByName (String cityName);
}
