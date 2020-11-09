package com.thymeleaf.course.domain.service;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.repository.UserRepository;
import com.thymeleaf.course.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {


    private List<User> userArrayList = new ArrayList<>();

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserArrayList() {
        return userArrayList;
    }

    @Transactional
    public void saveUser(UserSignUpRequest request) {
        User user = UserMapper.mapUserRequest2User(request);
        userArrayList.add(user);
        userRepository.save(user);
    }
}
