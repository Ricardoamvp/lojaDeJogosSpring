package com.ramvp.lojaDeJogos.exception;

import com.ramvp.lojaDeJogos.DTOs.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessageDTO> handleException(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ZonedDateTime timestamp = ZonedDateTime.now();
        String message = e.getMessage();
        String error = e.getClass().toString();

        if (e instanceof NotFoundException)
            status = HttpStatus.NOT_FOUND;

        ErrorMessageDTO errorMessage = new ErrorMessageDTO(timestamp, message, error);

        return ResponseEntity.status(status).body(errorMessage);
    }

}
