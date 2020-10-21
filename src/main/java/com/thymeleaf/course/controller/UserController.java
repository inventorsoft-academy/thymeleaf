package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping("/create")
    public String signUpUser(UserSignUpRequest user){
        return "registration";

    }

    @PostMapping("/create")
    public String signUpNewUser(UserSignUpRequest user){
        userService.saveUser(user);
        return "greetingPage";
    }

    @GetMapping("/greeting")
    public String sayHello(Model model){
        List<User> users = userService.getUsersList();
        model.addAttribute("greeting",users);
        return "greetingPage";
    }
}
