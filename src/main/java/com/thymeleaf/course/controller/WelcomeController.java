package com.thymeleaf.course.controller;

import com.thymeleaf.course.service.SignInUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class WelcomeController {

    private static final String WELCOME_PAGE = "welcomePage";

    @Autowired
    private SignInUpService signInUpService;

    @GetMapping("/")
    public String welcome(){
        return WELCOME_PAGE;
    }

}
