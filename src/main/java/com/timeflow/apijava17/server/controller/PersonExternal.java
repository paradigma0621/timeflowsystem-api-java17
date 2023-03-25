package com.timeflow.apijava17.server.controller;

import com.timeflow.apijava17.client.PersonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonExternal {

    @Autowired
    private PersonClient personClient;

    @GetMapping(value = "/getNameSaudation")
    public void getPersonNameFromCore() {
        String name = "Oswaldo";
        String msgReceived = personClient.getSaudation(name);
        System.out.println("Message Received: " + msgReceived);
    }
}