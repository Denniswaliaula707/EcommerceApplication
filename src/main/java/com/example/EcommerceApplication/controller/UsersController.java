package com.example.EcommerceApplication.controller;

import com.example.EcommerceApplication.model.OrderRequest;
import com.example.EcommerceApplication.model.Orders;
import com.example.EcommerceApplication.model.Users;
import com.example.EcommerceApplication.service.OrdersService;
import com.example.EcommerceApplication.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @SuppressWarnings("unused")
    private final OrdersService ordersService;

    @Autowired
    public UsersController(UsersService usersService, OrdersService ordersService) {
        this.usersService = usersService;
        this.ordersService = ordersService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users users) {
        try {
            usersService.registerUser(users);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error registering user: " + e.getMessage());
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Users>>getAllUsers() {
        try {
            List<Users> users = usersService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }

    }
    @PostMapping("/post-order")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            ordersService.createOrder(orderRequest.getUserId(), orderRequest.getNames());
            return ResponseEntity.ok("Order created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error in creating order: " + e.getMessage());
        }
    }

}


