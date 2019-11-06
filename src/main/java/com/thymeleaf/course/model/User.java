package com.thymeleaf.course.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@Component
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @Column(length = 30)
    private String email;

    @Column(length = 20)
    private String password;

}
