package com.thymeleaf.course.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class UserController {

    private static final String USER_PAGE = "userPage";

    @GetMapping("/user")
    public String getSignUpPage() {
        return USER_PAGE;
    }
}
