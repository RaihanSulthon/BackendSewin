package com.Sewin.Sewin3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyCart")
public class MyShopList {

    @Id
    private int id;
    private String nama;
    private String deskripsi;
    private String price;

    public MyShopList() {
        super();
    }
    
    public MyShopList(int id, String nama, String deskripsi, String price) {
        super();
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
