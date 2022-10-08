package com.example.REST.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Nie znaleziono zasobu!");
    }
}
