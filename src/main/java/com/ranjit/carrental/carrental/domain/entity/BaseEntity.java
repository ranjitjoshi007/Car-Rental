package com.ranjit.carrental.carrental.domain.entity;

import com.ranjit.carrental.carrental.security.IdToTokenIdSerializer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import tools.jackson.databind.annotation.JsonSerialize;


@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
