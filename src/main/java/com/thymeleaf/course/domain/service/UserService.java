package com.thymeleaf.course.domain.service;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.repository.UserRepository;
import com.thymeleaf.course.exception.ConfirmPasswordException;
import com.thymeleaf.course.exception.UserNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(UserSignUpRequest request) {
        if (confirmPassword(request)) {
            User user = new User();
            user.setUsername(request.getUsername());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));

            userRepository.save(user);
        } else throw new ConfirmPasswordException();
    }

    @Transactional(readOnly = true)
    public User getUser(String name) {
        return userRepository.findByUsernameOrEmail(name, name)
                .orElseThrow(() -> new UserNotFoundException("User not found with username : " + name));
    }

    private boolean confirmPassword(UserSignUpRequest request) {
        return request.getPassword().equals(request.getConfirmPassword());
    }

}