package com.dev.costumer_service.exceptions;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public record ErrorResponseDTO(
        String timestamp,
        int status,
        String error,
        String message,
        String path
) {
    public static ErrorResponseDTO of (HttpStatus status, String message, String path) {
       return new ErrorResponseDTO(
               Instant.now().truncatedTo(ChronoUnit.MILLIS).toString(),
               status.value(),
               status.getReasonPhrase(),
               message,
               path
       );
    }
}
