package com.thymeleaf.course.domain.service;

import com.thymeleaf.course.domain.model.dictionary.Role;
import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.repository.UserRepository;
import com.thymeleaf.course.excecptions.UnconfirmedPasswordException;
import com.thymeleaf.course.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public void saveUser(UserSignUpRequest request) {
        if (!request.isPasswordConfirmed()) {
            throw new UnconfirmedPasswordException("Password wasn't confirmed");
        }
        User user = UserMapper.mapUserRequest2User(request);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    public Optional<User> findUserByUserName(String email) {
        return userRepository.findByEmail(email);
    }
}
