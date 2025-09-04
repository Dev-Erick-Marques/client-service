package com.dev.client_service.dto;

public record ClientDTO(String cpf,
                        String nome,
                        Integer idade,
                        String endereco,
                        String sexo) {
}
