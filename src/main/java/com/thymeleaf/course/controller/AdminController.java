package com.thymeleaf.course.controller;

import com.thymeleaf.course.model.User;
import com.thymeleaf.course.service.SignInUpService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@AllArgsConstructor
@Controller
public class AdminController {

    private SignInUpService signInUpService;

    @GetMapping("/admin")
    public String adminPage() {
        return "adminPage";
    }

    @GetMapping("/admin/{id}")
    public ModelAndView userPage(@PathVariable long id, ModelAndView modelAndView) {
        return modelAndView;
    }

    @PutMapping("/admin/{id}")
    public boolean updateUser(@PathVariable long id, @RequestBody User user) {
        return signInUpService.update(id, user);
    }

    @DeleteMapping("/admin/{id}")
    public void removeUser(@PathVariable long id) {
        signInUpService.remove(id);
    }
}
