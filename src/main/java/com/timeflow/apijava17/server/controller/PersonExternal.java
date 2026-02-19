package com.timeflow.apijava17.server.controller;

import com.timeflow.apijava17.client.PersonClient;
import com.timeflow.apijava17.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api-persons")
public class PersonExternal {

    private final PersonClient personClient;

    @GetMapping(value = "/getPersons/customer/{customerId}")
    public List<PersonDto> getPersonFromReport(@PathVariable Long customerId, @RequestParam(defaultValue = "false") boolean removed) {
        return personClient.listByCustomer(customerId, removed);
    }
}