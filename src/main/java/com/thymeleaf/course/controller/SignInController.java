package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class SignInController {

    private static final String LOGIN_PAGE = "loginPage";

    @GetMapping("/login")
    public String getSignInPage(Model model) {
        model.addAttribute("user", new User());
        return LOGIN_PAGE;
    }

}


