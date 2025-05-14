package com.jstjnsn.coffeeapi.exception;

public class CoffeeNotFoundException extends RuntimeException {
    public CoffeeNotFoundException(Long id) {
        super("Coffee not found with ID: " + id);
    }
}
