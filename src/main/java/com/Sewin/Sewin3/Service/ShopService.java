package com.Sewin.Sewin3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sewin.Sewin3.Model.Shop;
import com.Sewin.Sewin3.Repository.ShopRepository;

@Service
public class ShopService {
    @Autowired
    private ShopRepository sRepo;

    public void save(Shop s) {
        sRepo.save(s);
    }

    public List<Shop> getAllClothes() {
        return sRepo.findAll();
    }

    public Shop getShopById(int id) {
        return sRepo.findById(id).get();
    }

    public void deleteById(int id){
        sRepo.deleteById(id);
    }
}
