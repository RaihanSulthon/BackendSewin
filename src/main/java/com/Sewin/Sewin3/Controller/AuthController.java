package com.Sewin.Sewin3.Controller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sewin.Sewin3.Model.user;
import com.Sewin.Sewin3.Repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    UserRepository userrepo;

    @GetMapping("/login2")
    public String login2(Model model){
        model.addAttribute("email", "");
        model.addAttribute("password", "");
        model.addAttribute("username", "");
        return "login2";
    }

    @PostMapping("/doLogin")
    public String doLogin(Model model, @RequestParam("email")String email, @RequestParam("password") String password) {
        user user = userrepo.findByEmail(email);
        System.out.println("password =" + password);
        System.out.println(user.getPassword());
        // if(user.getEmail().contains("@tailor.com")){
            
        // }
        if(user == null) {
            return "login2";
        }else{
            if(user.getPassword().equals(password)){
                return "redirect:/index";
            }
            return "login2";
        }
    }

    @PostMapping("/doSignUp")
    public String doSignUp(Model model, @RequestParam("email")String email, @RequestParam("password") String password, @RequestParam("username")String username){
        user user = new user(username, password, email);
        userrepo.save(user);
        return "login2";
    }
}
