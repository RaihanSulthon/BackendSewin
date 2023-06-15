package com.Sewin.Sewin3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sewin.Sewin3.Model.MyCart;
import com.Sewin.Sewin3.Repository.MyCartRepository;

@Service
public class MyShopListService {
    @Autowired
    private MyCartRepository myshop;

    public void saveMyShop(MyCart ms) {
        myshop.save(ms);
    }

    public List<MyCart> getAllClothes() {
        return myshop.findAll();
    }

    public void deleteById(int id) {
        myshop.deleteById(id);
    }

    public void clearCart() {
        myshop.deleteAll();
    }
}
