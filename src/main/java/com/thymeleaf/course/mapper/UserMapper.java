package com.thymeleaf.course.mapper;

import com.thymeleaf.course.domain.model.dto.UserDto;
import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

    private UserMapper() {
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static User mapUserRequest2User(UserSignUpRequest request) {
        return modelMapper.map(request, User.class);
    }

    public static UserDto mapUser2UserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
