package com.example.EcommerceApplication.model;

import java.util.List;

public class OrderRequest {
    private Long userId;
    private List<String> names;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getNames() {
        return names;
    }
    public void setNames(List<String> names) {
        this.names = names;
    }
}