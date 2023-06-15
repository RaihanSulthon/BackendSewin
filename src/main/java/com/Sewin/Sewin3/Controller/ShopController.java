package com.Sewin.Sewin3.Controller;

import java.security.Principal;
import java.util.*;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sewin.Sewin3.Model.MyCart;
import com.Sewin.Sewin3.Model.Shop;
import com.Sewin.Sewin3.Model.User;
import com.Sewin.Sewin3.Repository.MyCartRepository;
import com.Sewin.Sewin3.Repository.ShopRepository;
import com.Sewin.Sewin3.Repository.UserRepository;
import com.Sewin.Sewin3.Service.MyShopListService;
import com.Sewin.Sewin3.Service.ShopService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Controller
@Transactional
public class ShopController {
    @Autowired
    private ShopService service;

    @Autowired
    private MyShopListService myShopService;

    @Autowired
    private ShopRepository shopRepo;

    @Autowired
    MyCartRepository myCartRepo;

    @Autowired
    UserRepository userRepo;

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

        ModelAndView modelAndView = new ModelAndView("listShop");
        modelAndView.addObject("Shop", list);

        return modelAndView;
    }

    @PostMapping("/save")
    public String addProducts(@ModelAttribute Shop s, HttpServletRequest session) {
        User user = (User) session.getSession().getAttribute("user");
        s.setUser(user);
        shopRepo.save(s);
        return "redirect:/AvailableClothes";
    }

    @GetMapping("/MyCart")
    public String getMyCart(Model model, Principal principal, HttpServletRequest session) {
        User user = (User) session.getSession().getAttribute("user");
        if (user != null) {
            List<MyCart> list = myCartRepo.findByUser_id(user.getId());
            double total = 0;

            for (MyCart cart : list) {
                double price = Double.parseDouble(cart.getPrice());
                int quantity = cart.getQuantity();
                total += price * quantity;
            }

            model.addAttribute("Shop", list);
            model.addAttribute("totalPrice", total);
            return "MyCart";
        } else {
            return "login2";
        }
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id, HttpServletRequest session) {
        User user = (User) session.getSession().getAttribute("user");
        if (user != null) {

            Shop s = service.getShopById(id);
            List<MyCart> list = myCartRepo.findByUser_id(user.getId());

            if (!list.isEmpty()) {
                for (MyCart myCart : list) {
                    if (myCart.getNama().equals(s.getNama())) {
                        myCart.addQuantity(1);
                        myCart.setUser(user);
                        user.addMyCart(myCart);
                        userRepo.save(user);
                        user.resetMyCart();
                        return "redirect:/MyCart";
                    }
                }
                MyCart ms = new MyCart(s.getNama(), s.getDeskripsi(), s.getPrice(), s.getUser());
                ms.setUser(user);
                ms.addQuantity(1);
                user.addMyCart(ms);
                userRepo.save(user);
                user.resetMyCart();

            } else {
                MyCart ms = new MyCart(s.getNama(), s.getDeskripsi(), s.getPrice(), s.getUser());
                ms.setUser(user);
                ms.addQuantity(1);
                user.addMyCart(ms);
                userRepo.save(user);
                user.resetMyCart();
            }

            return "redirect:/MyCart";
        } else {
            return "login2";
        }
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

    @PostMapping("/clearCart")
    public String clearCart(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<MyCart> myCartList = myCartRepo.findByUser_id(user.getId());
        myCartRepo.deleteAllRows();
        return "redirect:/MyCart";
    }
}
