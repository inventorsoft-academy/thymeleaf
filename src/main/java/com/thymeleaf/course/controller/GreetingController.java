package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/greeting")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GreetingController {

    UserService userService;

    @GetMapping
    public String greeting(Model model, Principal principal) {

        model.addAttribute("user", userService.getUser(principal.getName()));

        return "greeting";
    }

}