package com.example.EcommerceApplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String category;
    private String description;
    private String specifications;
    private String reviews;
    private String relatedproducts;
    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    public List<Orders> orders;

    public Products() {
    }

    public Products(List<Orders> orders) {

        this.orders = orders;
    }

    public Products(Long id, String name, double price,
                    String category, String description,
                    String specifications, String reviews,
                    String relatedproducts, List<Orders> orders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.specifications = specifications;
        this.reviews = reviews;
        this.relatedproducts = relatedproducts;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getRelatedproducts() {
        return relatedproducts;
    }

    public void setRelatedproducts(String relatedproducts) {
        this.relatedproducts = relatedproducts;
    }
    
    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", specifications='" + specifications + '\'' +
                ", reviews='" + reviews + '\'' +
                ", relatedproducts='" + relatedproducts + '\'' +
                '}';
    }

}




