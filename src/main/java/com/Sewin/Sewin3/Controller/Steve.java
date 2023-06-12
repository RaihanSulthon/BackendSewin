package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Sewin.Sewin3.Model.user;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Steve {
    @GetMapping("/steve")
    public String steve(Model model, HttpServletRequest session) {
        user user = (user) session.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("sudahLogin", (boolean) false);
            return "Steve";
        } else {
            return "Steve";
        }
    }
}
