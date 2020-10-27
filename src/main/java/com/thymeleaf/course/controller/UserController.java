package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getUserArrayList());
        return "show-users";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserSignUpRequest());
        return "user-create";
    }

    @PostMapping("/create")
    public String createUser(UserSignUpRequest user) {
        userService.saveUser(user);
        return "redirect:/users/greeting";
    }

    @GetMapping("/greeting")
    public String sayHelloTo(Model model) {
        List<User> users = userService.getUserArrayList();
        model.addAttribute("greetingToUser", users);
        return "greeting-to-user";
    }

}
