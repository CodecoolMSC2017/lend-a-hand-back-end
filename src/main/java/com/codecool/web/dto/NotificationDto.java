package com.codecool.web.dto;

import com.codecool.web.model.Notification;

import java.time.LocalDateTime;

public class NotificationDto {

    private int id;

    private int fromId;

    private String fromName;

    private int toId;

    private String toName;

    private AdDto ad;

    private ApplicationDto application;

    private RatingTransferObject employeeRating;

    private RatingTransferObject employerRating;

    private ReportDto report;

    private String text;

    private String type;

    private Boolean read;

    private LocalDateTime timestamp;

    private Boolean deleted;

    public NotificationDto(Notification notification) {
        this.id = notification.getId();
        this.fromId = notification.getFrom().getId();
        this.fromName = notification.getFrom().getUserName();
        this.toId = notification.getTo().getId();
        this.toName = notification.getTo().getUserName();
        this.text = notification.getText();
        this.type = notification.getType();
        this.read = notification.getRead();
        this.timestamp = notification.getTimestamp();
        this.deleted = notification.getDeleted();
    }

    NotificationDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public AdDto getAd() {
        return ad;
    }

    public void setAd(AdDto ad) {
        this.ad = ad;
    }

    public ApplicationDto getApplication() {
        return application;
    }

    public void setApplication(ApplicationDto application) {
        this.application = application;
    }

    public RatingTransferObject getEmployeeRating() {
        return employeeRating;
    }

    public void setEmployeeRating(RatingTransferObject employeeRating) {
        this.employeeRating = employeeRating;
    }

    public RatingTransferObject getEmployerRating() {
        return employerRating;
    }

    public void setEmployerRating(RatingTransferObject employerRating) {
        this.employerRating = employerRating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ReportDto getReport() {
        return report;
    }

    public void setReport(ReportDto reportDto) {
        this.report = reportDto;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}

