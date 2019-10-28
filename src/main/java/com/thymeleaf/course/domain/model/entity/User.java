package com.thymeleaf.course.domain.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    @Column(name = "username", length = 20)
    String username;

    @NotEmpty
    @Column(name = "firstName", length = 40)
    String firstName;

    @NotEmpty
    @Column(name = "lastName")
    String lastName;

    @Email
    @NotEmpty
    @Column(name = "email", unique = true, length = 50)
    String email;

    @NotEmpty
    @Column(name = "password")
    String password;

    String role;
}
