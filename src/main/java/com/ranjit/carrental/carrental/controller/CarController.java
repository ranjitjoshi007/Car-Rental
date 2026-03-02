package com.ranjit.carrental.carrental.controller;

import com.ranjit.carrental.carrental.domain.entity.Car;
import com.ranjit.carrental.carrental.dto.request.car.CreateCarRequest;
import com.ranjit.carrental.carrental.exception.ForbiddenException;
import com.ranjit.carrental.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController extends BaseResourceController<Car, Long,CreateCarRequest,CreateCarRequest>{
    private final CarService service;


    @Override
    public ResponseEntity<List<Car>> getAll() {
        List<Car> list = service
                .getAllItems();
//                .map(CarMapper::toResponse);

        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<Car> getById(Long id) {
        Car car = service
                .getCarById(id);
//                .map(CarMapper::toResponse);

        return ResponseEntity.ok(car);
    }

    @Override
    public ResponseEntity<Car> create(@RequestBody CreateCarRequest entity) {
        throw new ForbiddenException("Method not allowed");
    }

    @Override
    public ResponseEntity<Car> update(Long aLong, CreateCarRequest entity) {
        throw new ForbiddenException("Method not allowed");
    }

    @Override
    public ResponseEntity<Car> partialUpdate(Long aLong, CreateCarRequest entity) {
        throw new ForbiddenException("Method not allowed");
    }

    @Override
    public void delete(Long aLong) {
        throw new ForbiddenException("Method not allowed");
    }
}
