package com.codecool.web.dto;

import com.codecool.web.model.Application;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ApplicationDto implements Serializable {

    private int id;

    private int adId;

    private String adTitle;

    private int applicantId;

    private String applicantName;

    private String message;

    private String state;

    private LocalDateTime timestamp;

    private String pictureLink;

    private int payment;

    private String type;


    public ApplicationDto(Application application) {
        this.id = application.getId();
        this.adId = application.getAd().getId();
        this.adTitle = application.getAd().getTitle();
        this.applicantId = application.getApplicant().getId();
        this.applicantName = application.getApplicant().getUserName();
        this.message = application.getMessage();
        this.timestamp = application.getTimestamp();
        this.state = application.getState();
        this.pictureLink = application.getAd().getPictureLink();
        this.payment = application.getAd().getPayment();
        this.type = application.getAd().getType();
    }

    public ApplicationDto(int id, int adId, String adTitle, int applicantId, String applicantName, String message, String state, LocalDateTime timestamp) {
        this.id = id;
        this.adId = adId;
        this.adTitle = adTitle;
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.message = message;
        this.state = state;
        this.timestamp = timestamp;
    }

    public ApplicationDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
