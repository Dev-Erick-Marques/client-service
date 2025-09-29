package com.dev.costumer_service.exceptions.handler;

import com.dev.costumer_service.exceptions.dto.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
     private <T> ResponseEntity<T> responseBuild(HttpStatus status, T body){
         return ResponseEntity.status(status).body(body);
     }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> GenericExceptionHandler(Exception ex,HttpServletRequest request){
        return errorResponse("Unexpected error",HttpStatus.INTERNAL_SERVER_ERROR, request.getRequestURI());
    }
    public ResponseEntity<ErrorResponseDTO> errorResponse(String message, HttpStatus status, String path){
         var response = ErrorResponseDTO.of(status, message, path);
         return responseBuild(status,response);
    }
}
