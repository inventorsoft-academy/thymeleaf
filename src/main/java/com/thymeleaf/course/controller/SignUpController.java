package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import com.thymeleaf.course.service.SignInUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequestMapping("/lelek_task")
public class SignUpController {

    private static final String SIGN_UP_PAGE = "signUpPage";
    private static final String USER_PAGE = "userPage";
    private static final String USER_EXIST = "User with this email already exist!";

    @Autowired
    private SignInUpService signInUpService;

    @Autowired
    private User user;

    @GetMapping("/sign_up")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", user);
        return SIGN_UP_PAGE;
    }

    @PostMapping(value = "/sign_up")
    public String signUp(Model model, @RequestParam String email, String password) {
        user.setEmail(email);
        user.setPassword(password);
        if (signInUpService.saveUser(user)) {
            return "redirect:/lelek_task/user";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("user_exist", USER_EXIST);
            log.info("User = " + user);
            return SIGN_UP_PAGE;
        }
    }

}
