package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import com.thymeleaf.course.service.SignInUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/lelek_task")
public class SignInController {

    private static final String SIGN_IN_PAGE = "signInPage";

    @Autowired
    private SignInUpService signInUpService;

    @GetMapping("/sign_in")
    public String getSignInPage(Model model) {
        model.addAttribute("user", new User());
        return SIGN_IN_PAGE;
    }
}


