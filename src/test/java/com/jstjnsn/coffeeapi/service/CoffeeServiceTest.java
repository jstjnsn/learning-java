package com.jstjnsn.coffeeapi.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.jstjnsn.coffeeapi.model.Coffee;
import com.jstjnsn.coffeeapi.repository.CoffeeRepository;

class CoffeeServiceTest {
    private final CoffeeRepository repository = mock(CoffeeRepository.class);
    private final CoffeeService service = new CoffeeService(repository);

    @Test
    void getCoffeeById_ReturnsCoffee() {
        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("Arabica");

        when(repository.findById(1L)).thenReturn(Optional.of(coffee));

        Coffee found = service.getCoffeeById(1L);
        assertEquals("Arabica", found.getName());
    }
}
