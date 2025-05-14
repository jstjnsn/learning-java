package com.jstjnsn.coffeeapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jstjnsn.coffeeapi.model.Coffee;
import com.jstjnsn.coffeeapi.service.CoffeeService;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {
    private final CoffeeService service;

    public CoffeeController(CoffeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Coffee> getAllCoffee() {
        return service.getAllCoffee();
    }

    @GetMapping("/{id}")
    public Coffee getCoffeeById(@PathVariable("id") Long id) {
        return service.getCoffeeById(id);
    }

    @PostMapping
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return service.createCoffee(coffee);
    }

    @PutMapping("/{id}")
    public Coffee updateCoffee(@PathVariable("id") Long id, @RequestBody Coffee updatedCoffee) {
        return service.updateCoffee(id, updatedCoffee);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable("id") Long id) {
        service.deleteCoffee(id);
    }
}
