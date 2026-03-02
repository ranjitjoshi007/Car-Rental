package com.ranjit.carrental.carrental.domain.entity;

import com.ranjit.carrental.carrental.domain.enums.CarType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;


    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    public Booking(String customerName, Car car, LocalDateTime startDate, LocalDateTime endDate, double totalPrice) {
    this.customerName = customerName;
    this.car = car;
    this.startDate = startDate;
    this.endDate = endDate;
    this.totalPrice = totalPrice;
    }
}
