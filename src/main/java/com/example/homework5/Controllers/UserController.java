package com.example.homework5.Controllers;

import com.example.homework5.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class UserController {

    private static ArrayList<User> users = new ArrayList<>();


    public static ModelAndView getUsersView(User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("users");
        mv.addObject("users", users);
        mv.addObject("user", user);
        mv.getModel();
        return mv;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User user){
        users.add(user);
    }


    public static boolean checkIfExist(User user){
        for(User item : users){
            if(user.compareTo(item) == 0){
                return true;
            }
        }
        return false;
    }
}
