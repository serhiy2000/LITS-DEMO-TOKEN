package com.lits.demo.controller;

import com.lits.demo.dtos.PersonDto;
import com.lits.demo.entity.Person;
import com.lits.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    @Qualifier (value = "alive")
    private PersonService alivePersonService;

    @GetMapping
    public List<PersonDto> getAllPersons (){
        return alivePersonService.getAllPersons();
    }

    @GetMapping (value = "/car/{name}/{car}")
    public List<PersonDto> getByNameAndCar (@PathVariable String name, @PathVariable String car){
        return alivePersonService.getByNameAndCar(name, car);
    }

    @GetMapping(value = "/{id}")
    public PersonDto getPersonById(@PathVariable Integer id) {
        return alivePersonService.getById(id);
    }

    @GetMapping(value = "/name/{name}")
    public Person getPersonByName (@PathVariable String name) {
        return alivePersonService.getByName(name);
    }

    @PostMapping
    public PersonDto savePerson (@RequestBody PersonDto person){
        return alivePersonService.save(person);
    }

    @PostMapping (value = "/delete{id}")
    public void message (@PathVariable Integer id){
        alivePersonService.deleteById(id);
    }

}
