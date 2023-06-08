package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class contact {
    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }
}
