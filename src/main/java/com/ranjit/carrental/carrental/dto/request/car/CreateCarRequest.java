package com.ranjit.carrental.carrental.dto.request.car;

import com.ranjit.carrental.carrental.domain.enums.CarType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateCarRequest {
    @NotBlank(message = "Car Type is required")
    private String type;
}
