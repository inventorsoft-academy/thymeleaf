package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "signUp")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserSignUpRequest());
        return "signUp";
    }

    @PostMapping(value = "signUp")
    public String signUp(@ModelAttribute @Valid UserSignUpRequest user) {
        userService.saveUser(user);
        return "redirect:/greeting";
    }
}
