package com.codecool.web.dto;

import com.codecool.web.model.Ad;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AdDto implements Serializable {

    private int id;

    private String title;

    private String description;

    private int payment;

    private String category;

    private boolean isPremium;

    private LocalDateTime timestamp;

    private String type;

    private int advertiserId;

    private String advertiserName;

    private String pictureLink;

    private String state;


    public AdDto(Ad ad) {
        this.id = ad.getId();
        this.title = ad.getTitle();
        this.description = ad.getDescription();
        this.payment = ad.getPayment();
        this.category = ad.getCategory();
        this.isPremium = ad.isPremium();
        this.timestamp = ad.getTimestamp();
        this.type = ad.getType();
        this.advertiserId = ad.getAdvertiser().getId();
        this.advertiserName = ad.getAdvertiser().getUserName();
        this.pictureLink = ad.getPictureLink();
        this.state = ad.getState();
    }
    public AdDto(String title, String description, String category, boolean isPremium,  String type, int advertiserId, String advertiserName) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.isPremium = isPremium;
        this.type = type;
        this.advertiserId = advertiserId;
        this.advertiserName = advertiserName;

    }

    public AdDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(boolean premium) {
        isPremium = premium;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(int advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
