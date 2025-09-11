package com.dev.costumer_service.entity;

import com.dev.costumer_service.dto.CostumerDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID costumerId;

    private UUID userId;
    private boolean isDeleted;
    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String sex;

    public Costumer(CostumerDTO dto, UUID userId){
        this.userId = userId;
        this.cpf = dto.cpf();
        this.name = dto.name();
        this.birthDate = dto.birthDate();
        this.address = dto.address();
        this.sex = dto.sex();
    }
    public Costumer(){
    }

}
