package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Sewin.Sewin3.Model.user;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

@Controller

public class index {
    @GetMapping("/index")
    public String index(Model model, HttpServletRequest session) {
        user user = (user) session.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("sudahLogin", (boolean) false);
            return "index";
        } else {
            return "index";
        }
    }
}