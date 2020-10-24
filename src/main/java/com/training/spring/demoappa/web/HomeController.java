package com.training.spring.demoappa.web;

import com.training.spring.demoappa.model.User;
import com.training.spring.demoappa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Value("${conference.name:bnf}")
    private String conference;

    @Secured("ROLE_HERO")
    @RequestMapping("/")
    public String home() {

        User u = User.builder().email("k@yahoo.fr").firstname("khemais").lastname("menzli").build();
        User u2 = User.builder().email("y@yahoo.fr").firstname("youssef").lastname("menzli").build();
        User u3 = User.builder().email("abdo@yahoo.fr").firstname("abdo").lastname("menzli").build();

        List<User> list = Stream.of(u, u2, u3).collect(Collectors.toList());;
        userRepository.saveAll(list);

        return "hello : " + conference;
    }

    @RequestMapping("/find")
    public User findByLastnameAndFirstname() {


        return userRepository.findByLastnameAndFirstname("menzli","khemais");
    }
}
