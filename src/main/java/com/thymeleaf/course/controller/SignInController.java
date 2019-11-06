package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import com.thymeleaf.course.service.SignInUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/lelek_task")
public class SignInController {

    private static final String SIGN_IN_PAGE = "signInPage";
    private static final String NOT_PRESENT = "There is no accounts with this email";
    private static final String WRONG_PASSWORD = "Wrong password";

    @Autowired
    private SignInUpService signInUpService;

    @Autowired
    private User user;

    @GetMapping("/sign_in")
    public String getSignInPage(Model model) {
        model.addAttribute("user", user);
        return SIGN_IN_PAGE;
    }

    @PostMapping(value = "/sign_in")
    public String signUp(Model model, @RequestParam String email, String password) {
        user.setEmail(email);
        user.setPassword(password);
        if (signInUpService.findByEmail(email).isPresent()) {
            if (signInUpService.findByEmail(email).get().getPassword().equals(password)) {
                return "redirect:/lelek_task/user";
            } else {
                model.addAttribute("user", user);
                model.addAttribute("message", WRONG_PASSWORD);
                return SIGN_IN_PAGE;
            }
        } else {
            model.addAttribute("user", user);
            model.addAttribute("message", NOT_PRESENT);
            return SIGN_IN_PAGE;
        }
    }
}


