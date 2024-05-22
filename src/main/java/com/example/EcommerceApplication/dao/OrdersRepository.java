package com.example.EcommerceApplication.dao;

import com.example.EcommerceApplication.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByUsersUserId(Long userId);

}


