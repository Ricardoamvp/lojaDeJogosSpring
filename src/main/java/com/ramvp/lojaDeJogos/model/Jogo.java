package com.ramvp.lojaDeJogos.model;

import javax.annotation.processing.Generated;

@Entity
@Table(name="tb_jogos")
public class jogos {

    @GeneratedValue(strategy = GenerationType.identity)
    private Long id;

}