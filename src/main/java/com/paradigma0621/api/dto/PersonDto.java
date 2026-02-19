package com.paradigma0621.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PersonDto(
        Long id,
        Long customerId,
        String name,
        LocalDate birthDate,
        LocalDateTime registerDate,
        Boolean removed
) {}

