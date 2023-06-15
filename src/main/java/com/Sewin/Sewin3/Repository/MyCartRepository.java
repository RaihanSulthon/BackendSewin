package com.Sewin.Sewin3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Sewin.Sewin3.Model.MyCart;


@Repository
public interface MyCartRepository extends JpaRepository<MyCart, Integer> {
    List<MyCart> findByUser_id(int userId);

    void deleteByUser_id(int userId);

    @Modifying
    @Query(value = "DELETE FROM my_cart", nativeQuery = true)
    void deleteAllRows();
}
