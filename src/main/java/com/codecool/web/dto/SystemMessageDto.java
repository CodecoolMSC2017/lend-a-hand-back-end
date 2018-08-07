package com.codecool.web.dto;

public class SystemMessageDto {

    private String message;

    public SystemMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
