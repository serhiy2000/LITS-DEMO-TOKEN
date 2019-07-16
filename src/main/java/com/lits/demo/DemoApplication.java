package com.lits.demo;

import com.lits.demo.entity.Person;
import com.lits.demo.entity.User;
import com.lits.demo.repository.PersonDataRepository;
import com.lits.demo.repository.UserDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableJpaRepositories
@ComponentScan (value = "com.lits.demo")
@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserDataRepository userDataRepository;

	@Autowired
	PersonDataRepository personDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = new User();
		user.setUsername("loco");
		user.setPassword("$2a$10$xIqXZRbKo96Y/h1uZa1eAuo53cNHIJffo5lqLsnLdhzfSpVB/XPoq");
//		user.setPassword(passwordEncoder.encode("123"));
		user.setRole("ADMIN");
		userDataRepository.save(user);

		Person person = new Person();
		person.setPersonName("John");
		person.setAge(17);
		personDataRepository.save(person);

		Person person2 = new Person();
		person2.setPersonName("Jack Sparrow");
		person2.setAge(15);
		personDataRepository.save(person2);

		Person person3 = new Person();
		person3.setPersonName("Jack Sparrow");
		person3.setAge(15);
		personDataRepository.save(person3);
	}
}
