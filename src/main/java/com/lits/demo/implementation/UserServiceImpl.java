package com.lits.demo.implementation;

import com.lits.demo.entity.User;
import com.lits.demo.exception.MyException;
import com.lits.demo.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Objects;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDataRepository.findOneByUsername(s);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        System.out.println("user from UserServiceImpl is "+ user);
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    public User saveUser (User user) {
        String userNull = null;
        try {userNull = userDataRepository.findOneByUsername(user.getUsername()).getUsername();
        } catch (NullPointerException e){
            System.out.println("I did manage to locate f**king Nullpointer!!!!");
        }
            if (userNull == null)
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userDataRepository.save(user);
        }
            else if (user.getUsername().equals(userDataRepository.findOneByUsername(user.getUsername()).getUsername()))
            {
                throw new MyException("User is in DB already");
            } else {
                throw new MyException("something is wrong in saveUser from userServiceImpl");
            }
        }
}
