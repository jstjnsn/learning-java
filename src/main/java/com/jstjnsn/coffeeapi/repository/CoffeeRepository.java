package com.jstjnsn.coffeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jstjnsn.coffeeapi.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
