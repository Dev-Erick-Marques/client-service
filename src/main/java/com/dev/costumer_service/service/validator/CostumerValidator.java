package com.dev.costumer_service.service.validator;

import com.dev.costumer_service.entity.Costumer;
import com.dev.costumer_service.exceptions.exceptions.CostumerNotFoundException;
import com.dev.costumer_service.repository.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
@AllArgsConstructor
@Component
public class CostumerValidator {
    private final CostumerRepository costumerRepository;

    public Costumer validateCostumer(UUID id){
        return costumerRepository.findByCostumerId(id)
                .orElseThrow(CostumerNotFoundException::new);
    }
}
