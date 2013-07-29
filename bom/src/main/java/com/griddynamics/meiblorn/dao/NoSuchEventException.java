package com.griddynamics.meiblorn.dao;

public class NoSuchEventException extends Exception {

    public NoSuchEventException() {
    }

    public NoSuchEventException(String message) {
        super(message);
    }
}
