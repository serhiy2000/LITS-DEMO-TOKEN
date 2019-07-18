package com.lits.demo.repository;

import com.lits.demo.DemoApplication;
import com.lits.demo.entity.Person;
import com.lits.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class) // seems no difference what annotation is used
@ContextConfiguration(classes = { DemoApplication.class })
@DataJpaTest
public class UserRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserDataRepository userDataRepository;

    @Test
    public void whenFindOneByName_thenReturnUser() {  // why this test fails????
        // given
        User usertobefound = new User();
        usertobefound.setUsername("delete");
        usertobefound.setPassword("23");
        entityManager.persist(usertobefound);
        entityManager.flush();

        // when
        User userfound = userDataRepository.findOneByUsername(usertobefound.getUsername());

        System.out.println(userfound.getUsername());
        // then
        assertThat(userfound.getUsername())
                .isEqualTo(usertobefound.getUsername());
    }

}
