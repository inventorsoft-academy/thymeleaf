package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor

public class GreetingsController {

    final UserService userService;

    @GetMapping("/greetings")
    public ModelAndView getLoginPage(ModelAndView model) {
        List<User> users = null;
        users = userService.findAll();
        model.addObject("usersFromServer", users);
        return model;
    }
}
