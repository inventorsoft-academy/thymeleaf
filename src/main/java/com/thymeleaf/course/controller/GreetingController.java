package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value = "/api")
public class GreetingController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/greeting")
    public String getPageCompanies(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("person", user);
        return "greeting";
    }
}
