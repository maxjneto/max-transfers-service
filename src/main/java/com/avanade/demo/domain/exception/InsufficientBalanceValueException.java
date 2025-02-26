package com.avanade.demo.domain.exception;

public class InsufficientBalanceValueException extends RuntimeException {
    public InsufficientBalanceValueException(String message) {
        super(message);
    }
}
