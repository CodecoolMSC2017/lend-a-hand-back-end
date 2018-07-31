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


    public ApplicationDto(Application application) {
        this.id = application.getId();
        this.adId = application.getAd().getId();
        this.adTitle = application.getAd().getTitle();
        this.applicantId = application.getApplicant().getId();
        this.applicantName = application.getApplicant().getUserName();
        this.message = application.getMessage();
        this.timestamp = application.getTimestamp();
        this.state = application.getState();
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
}
