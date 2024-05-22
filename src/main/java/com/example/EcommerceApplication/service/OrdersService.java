package com.example.EcommerceApplication.service;

import com.example.EcommerceApplication.dao.OrdersRepository;
import com.example.EcommerceApplication.dao.ProductsRepository;
import com.example.EcommerceApplication.dao.UsersRepository;
import com.example.EcommerceApplication.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    private final ProductsRepository productsRepository;

    private final UsersRepository usersRepository;
    @SuppressWarnings("unused")
    public static final Logger logger = LoggerFactory.getLogger(OrdersService.class);

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, ProductsRepository productsRepository, UsersRepository usersRepository) {
        this.ordersRepository = ordersRepository;
        this.productsRepository = productsRepository;
        this.usersRepository = usersRepository;
    }

    public void createOrder(Long userId, List<String> names) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));

        List<Products> products = names.stream()
                .map(name -> productsRepository.findByName(name)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid product name: " + name)))
                .collect(Collectors.toList());

        Orders order = new Orders();
        order.setUsers(user);
        order.setProducts(products);
        order.setTotalCost(order.calculateTotalCost());

        ordersRepository.save(order);
        logger.info("Order created successfully for user ID: " + userId);
    }
    public List<Orders> getOrdersByUserId(Long userId) {
        logger.info("Fetching orders for user ID: {}", userId);
        List<Orders> orders = ordersRepository.findByUsersUserId(userId);
        logger.info("Found {} orders for user ID: {}", orders.size(), userId);
        return orders;
    }



}







