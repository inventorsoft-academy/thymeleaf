package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import com.thymeleaf.course.service.SignInUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/lelek_task")
public class SignUpController {

    private static final String SIGN_UP_PAGE = "signUpPage";

    @Autowired
    private SignInUpService signInUpService;

    @GetMapping("/sign_up")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return SIGN_UP_PAGE;
    }

    @PostMapping(value = "/sign_up")
    public void signUp(@RequestParam String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        log.info("User = " + user);
        signInUpService.saveUser(user);
    }

    @PostMapping("/sign_in")
    public void signIn(@RequestBody User user) {
        signInUpService.signIn(user);
    }

}
