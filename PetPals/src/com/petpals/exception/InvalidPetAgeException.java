package com.petpals.exception;

public class InvalidPetAgeException extends Exception {
    public InvalidPetAgeException(String msg) {
        super(msg);
    }
}