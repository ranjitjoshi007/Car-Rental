package com.ranjit.carrental.carrental.dto.request.car;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCarRequest {
    @NotBlank(message = "Car Type is required")
    private String type;
}
