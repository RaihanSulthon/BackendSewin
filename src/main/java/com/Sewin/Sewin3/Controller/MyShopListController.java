package com.Sewin.Sewin3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Sewin.Sewin3.Service.MyShopListService;

@Controller
public class MyShopListController {
    
    @Autowired
    private MyShopListService service;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/MyCart";
    }
}
