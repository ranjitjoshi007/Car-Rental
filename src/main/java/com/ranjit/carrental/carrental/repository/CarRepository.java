package com.ranjit.carrental.carrental.repository;

import com.ranjit.carrental.carrental.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository  extends JpaRepository<Car, Long> {
}
