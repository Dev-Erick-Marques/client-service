package com.dev.costumer_service.exceptions.exceptions;

public class CostumersNotFoundException extends RuntimeException {
    private static final String MESSAGE = "No costumers were found";
    public CostumersNotFoundException() {
        super(MESSAGE);
    }
}
