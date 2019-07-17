package com.lits.demo.implementation;

import com.lits.demo.dtos.PersonDto;
import com.lits.demo.entity.Person;
import com.lits.demo.repository.PersonDataRepository;
import com.lits.demo.service.PersonService;
import com.lits.demo.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service ("alive")
@Slf4j

public class AlivePersonService implements PersonService {

    @Autowired
    private PersonDataRepository personDataRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDto getById(Integer id) {
        return personMapper.toDto(personDataRepository.findOneById(id));
    }

    @Override
    public List<PersonDto> getAllPersons () {
        Iterable<Person> personIterable = personDataRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person iteratorNext : personIterable) {
            personDtoList.add(personMapper.toDto(iteratorNext));
        }
        return personDtoList;
    }

    @Override
    public Person getByName (String personName){
        return personDataRepository.findOneByPersonName(personName);
    }

//        if () {    - тут написано як працює логер від лобмоку
//            throw new RuntimeException("User not found");
//            log.error("User not found");
//        }

    @Override
    public PersonDto save(PersonDto personDto) {
        Person entity = personMapper.toEntity(personDto);
        return personMapper.toDto(personDataRepository.save(entity));
    }

    @Override
    public void deleteById(Integer id) {
        Person personToBeDeleted = new Person();
        personToBeDeleted.setId(id);
        personDataRepository.delete(personToBeDeleted);
    }

    @Override
    public List<PersonDto> getByNameAndCar(String name, String car) {
        List<Person> iterable = personDataRepository.findByNameAndCar(name, car);
        return iterable.stream()
                .map(person -> personMapper.toDto(person))
                .collect(Collectors.toList());
    }
}
