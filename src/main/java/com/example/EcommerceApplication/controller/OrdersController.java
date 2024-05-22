package com.example.EcommerceApplication.controller;

import com.example.EcommerceApplication.model.Orders;
import com.example.EcommerceApplication.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.EcommerceApplication.service.OrdersService.logger;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    public final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable Long userId) {
        logger.info("Received request to fetch orders for user ID: {}", userId);
        List<Orders> orders = ordersService.getOrdersByUserId(userId);
        if (orders.isEmpty()) {
            logger.info("No orders found for user ID: {}", userId);
            return ResponseEntity.noContent().build();
        }
        logger.info("Returning {} orders for user ID: {}", orders.size(), userId);
        return ResponseEntity.ok(orders);
    }


}




