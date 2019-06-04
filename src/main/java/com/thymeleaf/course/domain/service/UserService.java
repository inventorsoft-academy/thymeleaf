package com.thymeleaf.course.domain.service;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.repository.UserRepository;
import com.thymeleaf.course.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    final UserRepository userRepository;

    @Transactional
    public void saveUser(UserSignUpRequest request) {
        User user = UserMapper.mapUserRequest2User(request);
        userRepository.save(user);
    }

    public User findByUsername(String name) {
        User user = userRepository.findByUsername(name);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user = userRepository.findByUsername(username);
          if (user == null) {
              throw new UsernameNotFoundException("User not found : " + username);
          }
        return user;
    }
}
