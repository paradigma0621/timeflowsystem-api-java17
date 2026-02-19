package com.paradigma0621.api.server.controller;

import com.paradigma0621.api.client.PersonClient;
import com.paradigma0621.api.dto.PersonDto;
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