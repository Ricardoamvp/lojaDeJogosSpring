package com.ramvp.lojaDeJogos.exception;

public class NotFoundException extends Exception {

    public NotFoundException() {
        super("NotFound");
    }

    public NotFoundException(String message) {
        super(message);
    }

}
