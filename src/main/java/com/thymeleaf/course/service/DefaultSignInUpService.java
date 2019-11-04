package com.thymeleaf.course.service;

import com.thymeleaf.course.dao.SignInUpAbstractDao;
import com.thymeleaf.course.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultSignInUpService implements SignInUpService {

    @Autowired
    private SignInUpAbstractDao signInUpAbstractDao;

    @Override
    public User saveUser(User user) {
        return signInUpAbstractDao.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return signInUpAbstractDao.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return signInUpAbstractDao.findById(id);
    }

    @Override
    public boolean signIn(User user) {
        return signInUpAbstractDao.findByEmail(user.getEmail()).get().equals(user);
    }

    @Override
    public boolean update(Long id, User user) {
        return signInUpAbstractDao.update(id, user);
    }

    @Override
    public void remove(Long id) {
        signInUpAbstractDao.remove(id);
    }
}
