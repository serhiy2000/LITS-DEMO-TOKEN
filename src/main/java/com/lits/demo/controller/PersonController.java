package com.lits.demo.controller;

import com.lits.demo.dtos.PersonDto;
import com.lits.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    @Qualifier (value = "alive")
    private PersonService alivePersonService;

    @GetMapping (value = "/person")
    public List<PersonDto> getAllPersons (){
        return alivePersonService.getAllPersons();
    }

    @GetMapping(value = "/person/{id}")
    public PersonDto getPersonById(@PathVariable Integer id) {
        return alivePersonService.getById(id);
    }

    @PostMapping (value = "/save")
    public PersonDto savePerson (@RequestBody PersonDto person){
        return alivePersonService.save(person);
    }

    @PostMapping (value = "/delete/{id}")
    public void message (@PathVariable Integer id){
        alivePersonService.deleteById(id);
    }

}
