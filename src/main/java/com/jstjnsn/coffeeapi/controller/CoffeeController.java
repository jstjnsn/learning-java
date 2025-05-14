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
import com.jstjnsn.coffeeapi.repository.CoffeeRepository;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {
    private final CoffeeRepository repository;

    public CoffeeController(CoffeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Coffee> getAllCoffee() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Coffee getCoffeeById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return repository.save(coffee);
    }

    @PutMapping("/{id}")
    public Coffee updateCoffee(@PathVariable Long id, @RequestBody Coffee updatedCoffee) {
        return repository.findById(id).map(coffee -> {
            coffee.setName(updatedCoffee.getName());
            return repository.save(coffee);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
