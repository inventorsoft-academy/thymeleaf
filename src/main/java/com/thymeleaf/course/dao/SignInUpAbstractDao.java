package com.thymeleaf.course.dao;

import com.thymeleaf.course.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class SignInUpAbstractDao {

    private SignInUpDao signInUpDao;

    public User save(final User user) {
        return signInUpDao.save(user);
    }

    public Optional<User> findByEmail(final String email) {
        return signInUpDao.findByEmail(email);
    }

    public Optional<User> findById(final Long id) {
        return signInUpDao.findById(id);
    }

    public boolean update(final Long id, final User user) {
        return false;
    }

    public void remove(final Long id) {
        signInUpDao.deleteById(id);
    }
}
