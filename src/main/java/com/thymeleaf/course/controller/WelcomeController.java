package com.thymeleaf.course.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class WelcomeController {

    private static final String WELCOME_PAGE = "welcomePage";

    @GetMapping("/")
    public String welcome() {
        return WELCOME_PAGE;
    }

}
