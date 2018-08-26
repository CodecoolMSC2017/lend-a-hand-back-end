package com.codecool.web.dto;

import com.codecool.web.model.User;

import java.io.Serializable;

public class UserAdDto implements Serializable {

    private User user;
    private AdDto ad;


    public UserAdDto(User user, AdDto ad) {
        this.user = user;
        this.ad = ad;
    }

    public UserAdDto() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AdDto getAd() {
        return ad;
    }

    public void setAd(AdDto ad) {
        this.ad = ad;
    }
}
