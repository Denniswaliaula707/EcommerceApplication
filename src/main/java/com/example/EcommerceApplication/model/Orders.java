package com.example.EcommerceApplication.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalCost;
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    public Users users;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    @JsonManagedReference
    private List<Products> products;

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
    public double calculateTotalCost() {
        return products.stream().mapToDouble(Products::getPrice).sum();
    }

    public void addProduct(Products product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", totalCost=" + totalCost +
                ", userId=" + userId +
                ", products=" + products +
                '}';
    }


}


