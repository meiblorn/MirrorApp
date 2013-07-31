package com.griddynamics.meiblorn.dao;

public class AlreadyInSpaceException extends Exception {

    public AlreadyInSpaceException() {
    }

    public AlreadyInSpaceException(String message) {
        super(message);
    }
}