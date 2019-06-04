package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/signup")
    public ModelAndView getSignUpPage(ModelAndView model) {
        model.setViewName("signUp");
        model.addObject("userSignUpRequest", new UserSignUpRequest());
        return model;
    }

    @PostMapping(value = "/signup")
    public String saveUser(@Valid @ModelAttribute UserSignUpRequest request,
                           BindingResult result) {
        if (result.hasErrors()) {
            result.addError(validatePassword(request));
            return "signUp";
        }
        userService.saveUser(request);
        return "redirect:/login";
    }

    private ObjectError validatePassword(UserSignUpRequest userRequest) {
        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            return new ObjectError("UserSignUpRequest", "Confirm password does not match");
        }
        return null;
    }
}
