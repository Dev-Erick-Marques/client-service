package com.dev.client_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
