package com.thymeleaf.course.domain.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSignUpRequest {

    @NotBlank
    @Size(min = 3, max = 30, message = "Name should be from 3 to 30 characters")
    String firstName;

    @NotBlank
    @Size(min = 3, max = 30, message = "Name should be from 3 to 30 characters")
    String lastName;

    @NotBlank
    @Email
    String email;

    @NotBlank
    @Size(min = 8, max = 30, message = "Password should be from 3 to 30 characters")
    String password;

    @NotBlank
    String confirmPassword;

}
