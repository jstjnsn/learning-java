package com.jstjnsn.coffeeapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jstjnsn.coffeeapi.exception.CoffeeNotFoundException;
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

    public Coffee getCoffeeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CoffeeNotFoundException(id));
    }

    public Coffee createCoffee(Coffee coffee) {
        return repository.save(coffee);
    }

    public Coffee updateCoffee(Long id, Coffee updatedCoffee) {
        return repository.findById(id).map(coffee -> {
            coffee.setName(updatedCoffee.getName());
            return repository.save(coffee);
        }).orElseThrow(() -> new CoffeeNotFoundException(id));
    }

    public void deleteCoffee(Long id) {
        if (!repository.existsById(id)) {
            throw new CoffeeNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
