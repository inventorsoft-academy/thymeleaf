package com.thymeleaf.course.domain.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
public class UserSignUpRequest {

    @NotEmpty(message = "Please, enter firstName")
    @Size(min = 3, max = 26, message = "FirstName mast be bigger than 3 letters and shorter than 26")
    @Pattern(regexp = "[a-zA-Z]*", message = "FirstName can contains english letters only")
    String firstName;

    @NotEmpty(message = "Please, enter lastName")
    @Size(min = 3, max = 26, message = "LastName mast be bigger than 3 letters and shorter than 26")
    @Pattern(regexp = "[a-zA-Z]*", message = "LastName can contains english letters only")
    String lastName;

    @NotEmpty(message = "Please, enter your email address")
    @Email(message = "Email has to be real")
    String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$!%^&+=])(?=\\S+$).{8,}$",
            message = "Password mast contains at least one number, special symbol, upper and lower case letter")
    @NotEmpty(message = "Please, enter password")
    String password;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^&+=])(?=\\S+$).{8,}$",
            message = "Password mast contains at least one number, special symbol, upper and lower case letter")
    @NotEmpty(message = "Please, confirm your password")
    String confirmPassword;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof UserSignUpRequest)) return false;
        UserSignUpRequest that = (UserSignUpRequest) object;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getConfirmPassword(), that.getConfirmPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPassword(), getConfirmPassword());
    }

    public boolean isPasswordConfirmed() {
        return this.confirmPassword.equals(this.password);
    }
}
