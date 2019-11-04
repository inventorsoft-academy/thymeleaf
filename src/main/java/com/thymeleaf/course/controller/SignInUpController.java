package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import com.thymeleaf.course.service.SignInUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping(value = "/lelek_task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class SignInUpController {

    private static final String SIGN_IN_PAGE = "signInPage";
    private static final String SIGN_UP_PAGE = "signUpPage";

    @Autowired
    private SignInUpService signInUpService;

    @GetMapping("/sign_in")
    public String getSignInPage() {
        return SIGN_IN_PAGE;
    }

    @GetMapping("/sign_up")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return SIGN_UP_PAGE;
    }

    @GetMapping("/{id}")
    public ModelAndView userPage(@PathVariable long id, ModelAndView modelAndView) {
        return modelAndView;
    }

    @PostMapping("/sign_up")
    public void signUp(@RequestBody User user) {
        log.info("User = " + user);
        signInUpService.saveUser(user);
    }

    @PostMapping("/sign_in")
    public void signIn(@RequestBody User user) {
        signInUpService.signIn(user);
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable long id, @RequestBody User user) {
        return signInUpService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable long id) {
        signInUpService.remove(id);
    }
}
