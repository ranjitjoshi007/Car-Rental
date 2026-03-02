package com.ranjit.carrental.carrental.dto.response;

import com.ranjit.carrental.carrental.domain.enums.CarType;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CarResponse {
    private Long id;
    private CarType type;

}
