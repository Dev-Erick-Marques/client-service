package com.dev.costumer_service.exceptions.exceptions;

public class CostumerNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Costumer not found";
    public CostumerNotFoundException() {
        super(MESSAGE);
    }
}
