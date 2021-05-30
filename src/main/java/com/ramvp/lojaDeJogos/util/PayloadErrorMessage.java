package com.ramvp.lojaDeJogos.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PayloadErrorMessage {

    private ZonedDateTime timestamp;
    private String message;
    private String error;

}
