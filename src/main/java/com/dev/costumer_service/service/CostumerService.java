package com.dev.costumer_service.service;

import com.dev.costumer_service.dto.CostumerDTO;
import com.dev.costumer_service.entity.Costumer;
import com.dev.costumer_service.exceptions.ResourceNotFoundException;
import com.dev.costumer_service.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository repository;


    public List<Costumer> getAllCostumers(){
        var costumers = repository.findAll();
        if (costumers.isEmpty()){
            throw new ResourceNotFoundException("No costumers were found");
        }
        return costumers;
    }

    public Costumer saveCostumer(CostumerDTO dto, String jwtSubject){

        UUID UserId = UUID.fromString(jwtSubject);
        return repository.save(new Costumer(dto, UserId));
    }

    public void softDeleteCostumerById(UUID id, Boolean isDeleted){
        repository.findByCostumerId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Costumer not found"));
        repository.softDeleteById(id, isDeleted);
    }

    public Costumer findCostumerById(UUID id){
        return repository.findByCostumerId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Costumer not found"));
    }


}
