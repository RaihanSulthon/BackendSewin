package com.Sewin.Sewin3.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Sewin.Sewin3.Model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer>{
    
}
