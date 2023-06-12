package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Sewin.Sewin3.Model.user;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

@Controller
public class contact {
    @GetMapping("/contact")
    public String contact(Model model, HttpServletRequest session) {
        user user = (user) session.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("sudahLogin", (boolean) false);
            return "contact";
        } else {
            return "contact";
        }
    }
}
