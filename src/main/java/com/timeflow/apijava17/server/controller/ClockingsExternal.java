package com.timeflow.apijava17.server.controller;

import com.timeflow.apijava17.client.ClockingClient;
import com.timeflow.apijava17.dto.ClockingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api-clockings")
public class ClockingsExternal {

    private final ClockingClient clockingClient;

    @GetMapping(value = "/getClockings/all")
    public Page<ClockingDto> getPersonFromReport() {
        Long personId = null;
        Boolean removed = null;
        LocalDateTime startFrom = null;
        LocalDateTime startTo = null;
        String subjectLike = null;
        var pageable = Pageable.ofSize(10);
        return clockingClient.findAll(personId, removed, startFrom, startTo, subjectLike, pageable);
    }
}