package com.jstjnsn.coffeeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jstjnsn.coffeeapi.model.Coffee;
import com.jstjnsn.coffeeapi.repository.CoffeeRepository;

@Service
public class CoffeeService {
    private final CoffeeRepository repository;

    public CoffeeService(CoffeeRepository repository) {
        this.repository = repository;
    }

    public List<Coffee> getAllCoffee() {
        return repository.findAll();
    }

    public Optional<Coffee> getCoffeeById(Long id) {
        return repository.findById(id);
    }

    public Coffee createCoffee(Coffee coffee) {
        return repository.save(coffee);
    }

    public Optional<Coffee> updateCoffee(Long id, Coffee updatedCoffee) {
        return repository.findById(id).map(coffee -> {
            coffee.setName(updatedCoffee.getName());
            return repository.save(coffee);
        });
    }

    public void deleteCoffee(Long id) {
        repository.deleteById(id);
    }
}
