package com.ramvp.lojaDeJogos.exception;

import com.ramvp.lojaDeJogos.util.PayloadErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<PayloadErrorMessage> handleException(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ZonedDateTime timestamp = ZonedDateTime.now();
        String message = e.getMessage();
        String error = e.getClass().toString();

        if (e instanceof NotFoundException)
            status = HttpStatus.NOT_FOUND;

        PayloadErrorMessage errorMessage = new PayloadErrorMessage(timestamp, message, error);

        return ResponseEntity.status(status).body(errorMessage);
    }

}
