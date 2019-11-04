package com.thymeleaf.course.controller;


import com.thymeleaf.course.domain.model.dto.UserDto;
import com.thymeleaf.course.domain.service.UserService;
import com.thymeleaf.course.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GreetingController {

    private final UserService userService;

    @GetMapping(value = "greeting")
    public String greeting(Model model, Principal principal) {
        UserDto userDto = UserMapper.mapUser2UserDto(
                userService.findUserByUserName(principal.getName()).
                        orElseThrow(() -> new UsernameNotFoundException("Looks like you've been logged out")));
        model.addAttribute("user", userDto);
        return "greeting";
    }


}
