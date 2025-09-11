package com.dev.costumer_service.dto;

import java.time.LocalDate;

public record CostumerDTO(String cpf,
                          String name,
                          LocalDate birthDate,
                          String address,
                          String sex) {
}
