package com.example.EcommerceApplication.service;

import com.example.EcommerceApplication.dao.ProductsRepository;
import com.example.EcommerceApplication.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public  List<Products> getProductsByCategory(String category) {

        return productsRepository.findByCategory(category);
    }
    public void addProduct(Products product) {

        productsRepository.save(product);
    }
    public void removeProductByID(Long id) {
        productsRepository.deleteById(id);
    }

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

}
