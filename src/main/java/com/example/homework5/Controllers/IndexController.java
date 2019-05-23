package com.example.homework5.Controllers;

import com.example.homework5.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class IndexController {
    @PostMapping
     static ModelAndView getIndexView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dashboard");
        mv.getModel();
        return mv;
    }

    @GetMapping
    static String getIndex(Model model) {
        model.addAttribute("user", new User());
        return "dashboard";
    }


}
