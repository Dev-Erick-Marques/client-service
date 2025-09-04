package com.dev.client_service.service;

import com.dev.client_service.entity.Client;
import com.dev.client_service.exceptions.ResourceNotFoundException;
import com.dev.client_service.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> getAllClients(){
        List<Client> client = repository.findAll();
        if (client.isEmpty()){
            throw new ResourceNotFoundException("Nenhum cliente foi encontrado");
        }
        return repository.findAll();
    }


}
