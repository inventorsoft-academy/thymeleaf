package com.thymeleaf.course.service;

import com.thymeleaf.course.dao.SignInUpDao;
import com.thymeleaf.course.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DefaultSignInUpService implements SignInUpService {

    private SignInUpDao signInUpDao;

    @Override
    public boolean saveUser(User user) {
        if (signInUpDao.findByEmail(user.getEmail()).isPresent()) {
            return false;
        } else {
            signInUpDao.save(user);
            return true;
        }
    }

    @Transactional
    @Override
    public Optional<User> findByEmail(String email) {
        return signInUpDao.findByEmail(email);
    }

    @Transactional
    @Override
    public Optional<User> findById(Long id) {
        return signInUpDao.findById(id);
    }

    @Transactional
    @Override
    public boolean signIn(User user) {
        return signInUpDao.findByEmail(user.getEmail()).get().equals(user);
    }

    @Transactional
    @Override
    public boolean update(Long id, User user) {
        if (signInUpDao.findById(id).isPresent()) {
            User daoUser = signInUpDao.findById(id).get();
            daoUser.setEmail(user.getEmail());
            daoUser.setPassword(user.getPassword());
            signInUpDao.save(daoUser);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public void remove(Long id) {
        signInUpDao.deleteById(id);
    }
}
