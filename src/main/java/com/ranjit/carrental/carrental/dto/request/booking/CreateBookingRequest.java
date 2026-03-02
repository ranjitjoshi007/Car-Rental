package com.ranjit.carrental.carrental.dto.request.booking;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CreateBookingRequest {
    private Long carId;
    private String customerName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

