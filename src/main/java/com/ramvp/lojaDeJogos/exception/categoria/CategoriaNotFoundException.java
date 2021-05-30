package com.ramvp.lojaDeJogos.exception.categoria;

import com.ramvp.lojaDeJogos.exception.NotFoundException;

public class CategoriaNotFoundException extends NotFoundException {

    public CategoriaNotFoundException() {
        super("Categoria não encontrada!");
    }

    public CategoriaNotFoundException(String message) {
        super(message);
    }

}
