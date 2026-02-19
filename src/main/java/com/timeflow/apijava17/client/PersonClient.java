package com.timeflow.apijava17.client;

import com.timeflow.apijava17.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "report", path = "/persons")
public interface PersonClient {
    @GetMapping(value = "/customer/{customerId}")
    List<PersonDto> listByCustomer(@PathVariable Long customerId, @RequestParam(defaultValue = "false") boolean removed);
}