package com.thymeleaf.course.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/lelek_task")
public class UserController {

    private static final String USER_PAGE = "userPage";

    @GetMapping("/user")
    public String getSignUpPage() {
        return USER_PAGE;
    }
}
