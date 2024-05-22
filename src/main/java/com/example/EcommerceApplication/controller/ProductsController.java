package com.example.EcommerceApplication.controller;

import com.example.EcommerceApplication.model.Products;
import com.example.EcommerceApplication.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductsController {

    private final ProductsService productsService;
    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/Allproducts")
    public ResponseEntity<List<Products>>getAllProducts() {
        try {
            List<Products> products = productsService.getAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/Allproducts/{product-category}")
    public List<Products> getProductsByCategory(@PathVariable("product-category") String category) {

        return productsService.getProductsByCategory(category);
    }
    @PostMapping("/Post-product")
    public ResponseEntity<String> addProduct(@RequestBody Products product) {
        try {
            productsService.addProduct(product);
            return ResponseEntity.ok("product added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating a product: " + e.getMessage());
        }
    }
    @DeleteMapping("/Allproducts/{product-id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeProduct( @PathVariable("product-id") Long id ) {
        productsService.removeProductByID(id);
    }
}





