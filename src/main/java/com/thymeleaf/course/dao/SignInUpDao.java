package com.thymeleaf.course.dao;

import com.thymeleaf.course.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignInUpDao extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
