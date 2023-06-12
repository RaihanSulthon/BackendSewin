package com.Sewin.Sewin3.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Sewin.Sewin3.Model.MyShopList;

@Repository
public interface MyShopRepository extends JpaRepository<MyShopList, Integer> {

}
