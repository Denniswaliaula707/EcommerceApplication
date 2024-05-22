package com.example.EcommerceApplication.dao;

import com.example.EcommerceApplication.model.Orders;
import com.example.EcommerceApplication.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findByCategory(String category);

    Optional<Products> findByName(String name);

}
