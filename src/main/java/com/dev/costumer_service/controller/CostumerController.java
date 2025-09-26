package com.dev.costumer_service.controller;

import com.dev.costumer_service.dto.CostumerDTO;
import com.dev.costumer_service.entity.Costumer;
import com.dev.costumer_service.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/costumers")
public class CostumerController {

    private final CostumerService service;
    private final  JwtDecoder jwtDecoder;

    @GetMapping("/all")
    public ResponseEntity<List<Costumer>> getAllClients(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getAllCostumers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Costumer> getCostumer(@PathVariable UUID id){
        return ResponseEntity.ok().body(
                service.findCostumerById(id)
        );
    }
    @PostMapping("/register")
    public  ResponseEntity<Costumer> registerCostumer(@RequestBody CostumerDTO dto,@AuthenticationPrincipal Jwt jwt){
        return ResponseEntity.ok().body(
                service.saveCostumer(dto, jwt.getSubject())
        );
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("{id}/delete")
    public ResponseEntity<Void> softDeleteCostumerById(@PathVariable UUID id){
        service.softDeleteCostumerById(id,true);
        return ResponseEntity.noContent().build();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}/restore")
    public ResponseEntity<Void> restoreSoftDeleteCostumerById(@PathVariable UUID id){
        service.softDeleteCostumerById(id,false);
        return ResponseEntity.noContent().build();
    }
}
