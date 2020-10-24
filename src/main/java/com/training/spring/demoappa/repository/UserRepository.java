package com.training.spring.demoappa.repository;

import com.training.spring.demoappa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @RestResource(path = "by-lastname")
    List<User> findByLastname(@Param("id") String lastname);
    User findByEmail (String email);
    User findByLastnameAndFirstname(String lastname, String firstname);
}
