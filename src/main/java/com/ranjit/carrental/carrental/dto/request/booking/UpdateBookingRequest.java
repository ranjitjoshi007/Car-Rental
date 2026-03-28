package com.ranjit.carrental.carrental.dto.request.booking;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateBookingRequest {
    private long carId;

    private String customerName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}

