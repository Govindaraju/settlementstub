package com.gimpact.settlement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SettlementException extends RuntimeException {
    public SettlementException(String message) {
        super(message);
    }
}