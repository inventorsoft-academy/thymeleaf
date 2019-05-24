package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GreetingController {

    private User currentUser=new User();

    @GetMapping("/home")
    public String homeController(Model model){
        model.addAttribute(currentUser);
        return "signUp";
    }

    @PostMapping("/signUp")
    public String helloPage(@ModelAttribute @Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "signUp";
        }else{
            return "HelloPage";
        }
    }

    @GetMapping("/signUp")
    public String signupPage(){
        return "signUp";
    }
}
