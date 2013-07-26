package com.griddynamics.meiblorn.domain;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

@SpaceClass
public class Event {
    private int id;
    private String message;

    public Event() {

    }

    public Event(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @SpaceId
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
}