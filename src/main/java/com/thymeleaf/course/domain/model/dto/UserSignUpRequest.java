package com.thymeleaf.course.domain.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSignUpRequest {

    @NotBlank
    @Size(min = 3, max = 10, message = "First name invalid")
    String firstName;

    @NotBlank
    @Size(min = 3, max = 10, message = "Last name invalid")
    String lastName;

    @NotBlank
    @Size(min = 3, max = 10, message = "User name invalid")
    String username;

    @NotBlank
    @Email
    String email;

    @NotBlank
    @Size(min = 5, max = 35, message = "Password invalid")
    String password;

    @NotBlank
    String confirmPassword;
}
