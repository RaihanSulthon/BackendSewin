package com.Sewin.Sewin3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sewin.Sewin3.Model.MyShopList;
import com.Sewin.Sewin3.Repository.MyShopRepository;

@Service
public class MyShopListService {
    @Autowired
    private MyShopRepository myshop;

    public void saveMyShop(MyShopList ms){
        myshop.save(ms);
    }

    public List<MyShopList> getAllClothes(){
        return myshop.findAll();
    }

    public void deleteById(int id){
        myshop.deleteById(id);
    }
}
