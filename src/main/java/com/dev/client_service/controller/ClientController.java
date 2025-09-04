package com.dev.client_service.controller;

import com.dev.client_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/clients")
    public ResponseEntity<?> getAllClients(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getAllClients());
    }
}
