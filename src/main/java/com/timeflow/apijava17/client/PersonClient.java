package com.timeflow.apijava17.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "report-java8")
public interface PersonClient {
    @GetMapping(value = "/persons/getPersonMsg")
    public String getSaudation(@RequestParam("name") String name);
}