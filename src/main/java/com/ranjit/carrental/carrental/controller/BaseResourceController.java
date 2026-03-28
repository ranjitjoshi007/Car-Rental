package com.ranjit.carrental.carrental.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class  BaseResourceController<T, ID,C,U> {
    @GetMapping
    public abstract ResponseEntity<List<T>> getAll();

    @GetMapping("/{id}")
    public abstract ResponseEntity<T> getById(@PathVariable ID id);

    @PostMapping
    public abstract ResponseEntity<T> create(@RequestBody C entity);


    @PutMapping("/{id}")
    public abstract ResponseEntity<T> update(@PathVariable ID id, @RequestBody U entity);

    @PatchMapping("/{id}")
    public abstract ResponseEntity<T> partialUpdate(@PathVariable ID id, @RequestBody U entity);

    @DeleteMapping("/{id}")
    public abstract void delete(@PathVariable ID id);
}
