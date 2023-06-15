package com.Sewin.Sewin3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sewin.Sewin3.Model.User;
import com.Sewin.Sewin3.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    UserRepository userrepo;

    @GetMapping("/login2")
    public String login2(Model model) {
        model.addAttribute("email", "");
        model.addAttribute("password", "");
        model.addAttribute("username", "");
        return "login2";
    }

    @GetMapping("/logout")
    public String doLogout(Model model, HttpServletRequest Session) {
        Session.getSession().removeAttribute("user");
        Session.getSession().invalidate();
        return "login2";
    }

    @PostMapping("/doLogin")
    public String doLogin(Model model, @RequestParam("email") String email, @RequestParam("password") String password,
            HttpServletRequest request) {
        User user = userrepo.findByEmail(email);
        System.out.println("password =" + password);
        System.out.println(user.getPassword());
        if (user == null) {
            return "login2";
        } else {
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                return "redirect:/index";
            }
            return "login2";
        }
    }

    @PostMapping("/doSignUp")
    public String doSignUp(Model model, @RequestParam("email") String email, @RequestParam("password") String password,
            @RequestParam("username") String username) {
        User user = new User(username, password, email);
        userrepo.save(user);
        return "login2";
    }
}
