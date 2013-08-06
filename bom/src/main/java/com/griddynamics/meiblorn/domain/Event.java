package com.griddynamics.meiblorn.domain;

import java.io.Serializable;

public class Event implements Serializable {
    private int id;
    private String message;

    public Event() {

    }

    public Event(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
