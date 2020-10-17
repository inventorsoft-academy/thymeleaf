package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping(value = "/signUp")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping(value = "/signUp")
    public String getSignUpPage(ModelAndView model) {
        model.addObject("userSignUpRequest", new UserSignUpRequest());
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String saveUser(@Valid @ModelAttribute UserSignUpRequest userSignUpRequest,
                                 BindingResult bindingResult,
                                 ModelAndView model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/signUp";
        }
        userService.saveUser(userSignUpRequest);
        return "redirect:/greetings";
    }
}
