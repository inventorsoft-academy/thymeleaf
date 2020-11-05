package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;


    @GetMapping("/show")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getUserArrayList());
        return "homework/show-users";
    }

    @GetMapping("/create")
    public String createUserForm(@ModelAttribute("user") UserSignUpRequest user) {
        return "homework/user-create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") UserSignUpRequest user) {
        userService.saveUser(user);
        return "redirect:/users/greeting";
    }

    @GetMapping("/greeting")
    public String sayHelloTo(Model model) {
        List<User> users = userService.getUserArrayList();
        model.addAttribute("greetingToUser", users);
        return "homework/greeting-to-user";
    }

}
