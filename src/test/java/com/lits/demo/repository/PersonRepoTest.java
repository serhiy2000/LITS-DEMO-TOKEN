package com.lits.demo.repository;

import com.lits.demo.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    PersonDataRepository personDataRepository;

    @Test
    public void whenFindByName_thenReturnPerson() {
        // given
        Person personToBeFound = new Person ();
        personToBeFound.setPersonName("delete");
        personToBeFound.setAge(23);
        entityManager.persist(personToBeFound);
        entityManager.flush();

        // when
        Person personFound = personDataRepository.findOneById(personToBeFound.getId());

        System.out.println(personFound.getPersonName());
        // then
        assertThat(personFound.getPersonName())
                .isEqualTo(personToBeFound.getPersonName());
    }
}
