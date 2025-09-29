package com.dev.costumer_service.service;

import com.dev.costumer_service.dto.CostumerDTO;
import com.dev.costumer_service.entity.Costumer;
import com.dev.costumer_service.exceptions.exceptions.CostumersNotFoundException;
import com.dev.costumer_service.repository.CostumerRepository;
import com.dev.costumer_service.service.validator.CostumerValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CostumerService {

    private final CostumerRepository costumerRepository;
    private final CostumerValidator validator;

    public List<Costumer> getAllCostumers(){
        var costumers = costumerRepository.findAll();
        if (costumers.isEmpty()){
            throw new CostumersNotFoundException();
        }
        return costumers;
    }
    public Costumer saveCostumer(CostumerDTO costumerDTO, String jwtSubject){
        UUID UserId = UUID.fromString(jwtSubject);
        return costumerRepository.save(new Costumer(costumerDTO, UserId));
    }

    public void softDeleteCostumerById(UUID id, Boolean isDeleted){
        validator.validateCostumer(id);
        costumerRepository.softDeleteById(id, isDeleted);
    }

    public Costumer findCostumerById(UUID id){
        return validator.validateCostumer(id);
    }


}
