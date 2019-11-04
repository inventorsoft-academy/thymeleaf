package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import com.thymeleaf.course.service.SignInUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/lelek_task")
public class AdminController {

    @Autowired
    private SignInUpService signInUpService;

    @GetMapping("/{id}")
    public ModelAndView userPage(@PathVariable long id, ModelAndView modelAndView) {
        return modelAndView;
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
