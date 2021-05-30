package com.ramvp.lojaDeJogos.exception.jogo;

import com.ramvp.lojaDeJogos.exception.NotFoundException;

public class JogoNotFoundException extends NotFoundException {

    public JogoNotFoundException() {
        super("Jogo não encontrado!");
    }

    public JogoNotFoundException(String message) {
        super(message);
    }

}
