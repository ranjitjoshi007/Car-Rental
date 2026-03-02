package com.ranjit.carrental.carrental.service;

import com.ranjit.carrental.carrental.domain.entity.Car;
import com.ranjit.carrental.carrental.exception.ResourceNotFoundException;
import com.ranjit.carrental.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    public List<Car> getAllItems() {
        return repository.findAll();
    }
    public Car getCarById(Long id) {
        try {
            repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Knowledge item not found"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Knowledge item not found"));
    }



}
