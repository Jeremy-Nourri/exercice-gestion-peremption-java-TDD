package org.example.exception;

public class ValueGreaterThan50Exception extends RuntimeException {
    public ValueGreaterThan50Exception(String message) {
        super(message);
    }
}
