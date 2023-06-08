package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller

public class index {
    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }
}