package com.dev.costumer_service.service;

import com.dev.costumer_service.dto.CostumerDTO;
import com.dev.costumer_service.entity.Costumer;
import com.dev.costumer_service.exceptions.ResourceNotFoundException;
import com.dev.costumer_service.repository.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CostumerService {

    private final CostumerRepository costumerRepository;
    private final WebClient webClient;

    public List<Costumer> getAllCostumers(){
        var costumers = costumerRepository.findAll();
        if (costumers.isEmpty()){
            throw new ResourceNotFoundException("No costumers were found");
        }
        return costumers;
    }
    public Costumer saveCostumer(CostumerDTO costumerDTO, String jwtSubject){
        UUID UserId = UUID.fromString(jwtSubject);
        return costumerRepository.save(new Costumer(costumerDTO, UserId));
    }

    public void softDeleteCostumerById(UUID id, Boolean isDeleted){
        costumerRepository.findByCostumerId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Costumer not found"));
        costumerRepository.softDeleteById(id, isDeleted);
    }

    public Costumer findCostumerById(UUID id){
        return costumerRepository.findByCostumerId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Costumer not found"));
    }


}
