package com.timeflow.apijava17.dto;

import java.time.LocalDateTime;

public record ClockingDto(Long id, Long secondsDuration, Double grade, String description, String subject,
                          LocalDateTime startDate, LocalDateTime finishDate, String localization, Long personId,
                          boolean removed) { }