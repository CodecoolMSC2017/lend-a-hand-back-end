package com.codecool.web.model;

public class Message extends AbstractModel {

    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
