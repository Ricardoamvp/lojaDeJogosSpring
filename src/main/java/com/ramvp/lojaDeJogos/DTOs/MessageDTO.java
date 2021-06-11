package com.ramvp.lojaDeJogos.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MessageDTO {

    private ZonedDateTime timestamp;
    private String message;

    public MessageDTO(String message) {
        this.timestamp = ZonedDateTime.now();
        this.message = message;
    }

}
