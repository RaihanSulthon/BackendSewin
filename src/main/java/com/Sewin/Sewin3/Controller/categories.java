package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class categories {
    @GetMapping("/categories")
    public String categories(Model model){
        return "categories";
    }
}
