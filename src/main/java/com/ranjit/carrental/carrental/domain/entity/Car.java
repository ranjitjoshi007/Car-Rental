package com.ranjit.carrental.carrental.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ranjit.carrental.carrental.domain.enums.CarType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarType type = CarType.SEDAN;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "price_per_day", nullable = false)
    private double pricePerDay=50;

    @Column(name = "price_per_hour", nullable = false)
    private double pricePerHour=10;


//    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<Booking> bookings;
}
