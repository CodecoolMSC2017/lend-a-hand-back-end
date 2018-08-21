package com.codecool.web.dto;

import com.codecool.web.model.User;

import java.io.Serializable;

public class UserContactDto implements Serializable {

    private User user;
    private Contact contact;


    public UserContactDto(User user, Contact contact) {
        this.user = user;
        this.contact = contact;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
