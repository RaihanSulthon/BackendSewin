package com.Sewin.Sewin3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class nopal {
    @GetMapping("/nopal")
    public String nopal(Model model) {
        return "nopal";
    }
}
