package com.ranjit.carrental.carrental.mapper;

import com.ranjit.carrental.carrental.domain.entity.Car;
import com.ranjit.carrental.carrental.domain.enums.CarType;
import com.ranjit.carrental.carrental.dto.request.car.CreateCarRequest;
import com.ranjit.carrental.carrental.dto.response.CarResponse;

public class CarMapper {

    public static Car toEntity(CreateCarRequest dto) {
        return Car.builder()
                .type(CarType.valueOf(dto.getType()))
                .build();
    }
    public static CarResponse toResponse(Car car) {
        return CarResponse.builder()
                .id(car.getId())
                .type(car.getType())

                .build();
    }
}
