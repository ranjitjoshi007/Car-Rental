package com.ranjit.carrental.carrental.dto.request.car;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateBookingRequest {
    @NotBlank(message = "Car is required")
    private long carId;

    @NotBlank(message = "Customer Name is required")
    private String customerName;

    @NotBlank(message = "Start date is required")
    private LocalDateTime startDate;

    @NotBlank(message = "End date is required")
    private LocalDateTime endDate;
}
