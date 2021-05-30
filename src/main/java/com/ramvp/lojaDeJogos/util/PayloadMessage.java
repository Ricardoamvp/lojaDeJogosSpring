package com.ramvp.lojaDeJogos.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PayloadMessage {

    private ZonedDateTime timestamp;
    private String message;

    public PayloadMessage(String message) {
        this.timestamp = ZonedDateTime.now();
        this.message = message;
    }

}
