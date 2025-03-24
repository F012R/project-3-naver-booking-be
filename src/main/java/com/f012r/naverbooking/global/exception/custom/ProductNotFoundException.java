package com.f012r.naverbooking.global.exception.custom;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Product Not Found");
    }
}
