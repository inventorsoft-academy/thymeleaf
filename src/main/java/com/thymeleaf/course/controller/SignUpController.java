package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import com.thymeleaf.course.service.SignInUpService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@AllArgsConstructor
public class SignUpController {

    private static final String REGISTRATION_PAGE = "registrationPage";
    private static final String USER_EXIST = "User with this email already exist!";

    private SignInUpService signInUpService;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return REGISTRATION_PAGE;
    }

    @PostMapping("/register")
    public String signUp(Model model, @RequestParam String email, String password) {
        log.info("Sign up page post called");
        User user = new User();
        user.setEmail(email);
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(password));
        if (signInUpService.saveUser(user)) {
            return "redirect:/user";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("user_exist", USER_EXIST);
            log.info("User = " + user);
            return REGISTRATION_PAGE;
        }
    }

}
