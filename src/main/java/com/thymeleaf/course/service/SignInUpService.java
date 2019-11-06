package com.thymeleaf.course.service;

import com.thymeleaf.course.model.User;

import java.util.Optional;

public interface SignInUpService {

    boolean saveUser(User user);

    Optional<User> findByEmail(final String email);

    Optional<User> findById(final Long id);

    boolean signIn(User user);

    boolean update(final Long id, final User user);

    void remove(final Long id);

}