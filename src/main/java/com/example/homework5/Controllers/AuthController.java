package com.example.homework5.Controllers;

import com.example.homework5.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthController {
    //TODO add validation
    @RequestMapping(value = "/singUp", method= RequestMethod.POST)
    private ModelAndView singUp(@Valid @ModelAttribute("user") User user,BindingResult result) {

        if(result.hasErrors()){
            return IndexController.getIndexView();
        }
        else if(UserController.checkIfExist(user)){
            FieldError error = new FieldError("user", "email",
                    "User with this email already exists!");
            result.addError(error);
            return IndexController.getIndexView();
        }
        else {
            UserController.addUser(user);
            return UserController.getUsersView(user);
        }


    }

    //TODO add validation
    @RequestMapping(value = "/singIn", method= RequestMethod.POST)
    private ModelAndView singIn(@RequestParam String email, String password) {
        User user = UserController.getUsers().stream()
                .filter(user1 ->user1.getEmail().equals(email) )
                .filter(user1 ->user1.getPassword().equals(password) )
                .findAny().orElse(null);

        if(user!=null){
            return UserController.getUsersView(user);
        }
        else {
            return IndexController.getIndexView();
        }


    }
}
