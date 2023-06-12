package com.Sewin.Sewin3.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Sewin.Sewin3.Model.MyShopList;
import com.Sewin.Sewin3.Model.Shop;
import com.Sewin.Sewin3.Service.MyShopListService;
import com.Sewin.Sewin3.Service.ShopService;

@Controller
public class ShopController {
    @Autowired
    private ShopService service;

    @Autowired
    private MyShopListService myShopService;

    @GetMapping("/Shop")
    public String Shop(Model model) {
        return "Shop";
    }

    @GetMapping("/AddProducts")
    public String AddProducts(Model model) {
        return "AddProducts";
    }

    @GetMapping("/AvailableClothes")
    public ModelAndView getAllClothes() {
        List<Shop> list = service.getAllClothes();
        return new ModelAndView("listShop", "Shop", list);
    }

    @PostMapping("/save")
    public String addProducts(@ModelAttribute Shop s) {
        service.save(s);
        return "redirect:/AvailableClothes";
    }

    @GetMapping("/MyCart")
    public String getMyCart(Model model) {
        List<MyShopList> list = myShopService.getAllClothes();
        model.addAttribute("Shop", list);
        return "MyCart";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Shop s = service.getShopById(id);
        MyShopList ms = new MyShopList(s.getId(), s.getNama(), s.getDeskripsi(), s.getPrice());
        myShopService.saveMyShop(ms);
        return "redirect:/MyCart";
    }

    @RequestMapping("/editShop/{id}")
    public String editShop(@PathVariable("id") int id, Model model) {
        Shop s = service.getShopById(id);
        model.addAttribute("Shop", s);
        return "ShopEdit";
    }

    @RequestMapping("/deleteShop/{id}")
    public String deleteShop(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/AvailableClothes";
    }
}
