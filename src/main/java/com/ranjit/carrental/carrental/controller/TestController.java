package com.ranjit.carrental.carrental.controller;

import com.ranjit.carrental.carrental.domain.entity.Car;
import com.ranjit.carrental.carrental.dto.request.car.CreateCarRequest;
import com.ranjit.carrental.carrental.dto.request.car.UpdateCarRequest;
import com.ranjit.carrental.carrental.exception.ForbiddenException;
import com.ranjit.carrental.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestController {
    private final CarService service;


    @GetMapping
    public ResponseEntity<String> getAll() {

        return ResponseEntity.ok("Ranjit");
    }
}
