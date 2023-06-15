package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Sewin.Sewin3.Model.User;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

@Controller
public class products {
    @GetMapping("/products")
    public String products(Model model, HttpServletRequest session) {
        User user = (User) session.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("sudahLogin", (boolean) false);
            return "products";
        } else {
            return "login2";
        }
    }
}
