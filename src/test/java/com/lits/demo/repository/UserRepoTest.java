package com.lits.demo.repository;

import com.lits.demo.entity.Person;
import com.lits.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserDataRepository userDataRepository;

    @Test
    public void whenFindByName_thenReturnUser() {  // why this test fails????
        // given
        User usertobefound = new User();
        usertobefound.setUsername("delete");
        usertobefound.setPassword("23");
        entityManager.persist(usertobefound);
        entityManager.flush();

        System.out.println(usertobefound.getUsername()+" trying to find peron");
        // when
        User userfound = userDataRepository.findOneByUsername(usertobefound.getUsername());

        System.out.println(userfound.getUsername());
        // then
        assertThat(userfound.getUsername())
                .isEqualTo(usertobefound.getUsername());
    }

}
