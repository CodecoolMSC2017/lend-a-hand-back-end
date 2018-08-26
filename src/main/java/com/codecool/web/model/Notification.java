package com.codecool.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_id")
    @JsonBackReference(value = "from-notification")
    private User from;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_id")
    @JsonBackReference(value = "to-notification")
    @NotNull
    private User to;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_id")
    @JsonBackReference(value = "ad-notification")
    private Ad ad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "application_id")
    @JsonBackReference(value = "application-notification")
    private Application application;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_rating_id")
    @JsonBackReference(value = "employee-notification")
    private EmployeeRating employeeRating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_rating_id")
    @JsonBackReference(value = "employer-notification")
    private EmployerRating employerRating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "report_id")
    @JsonBackReference(value = "report-notification")
    private Report report;

    @NotNull
    private String text;

    @NotNull
    private String type;

    @NotNull
    private Boolean read;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private Boolean deleted;

    public Notification() {
    }

    Notification(User from, User to, Ad ad, String type, String text, LocalDateTime timestamp) {
        this.from = from;
        this.to = to;
        this.ad = ad;
        this.read = false;
        this.type = type;
        this.text = text;
        this.timestamp = timestamp;
        this.deleted = false;
    }

    Notification(User from, User to, Application application, String type, String text, LocalDateTime timestamp) {
        this.from = from;
        this.to = to;
        this.application = application;
        this.read = false;
        this.type = type;
        this.text = text;
        this.timestamp = timestamp;
        this.deleted = false;
    }

    Notification(User from, User to, EmployeeRating employeeRating, String type, String text, LocalDateTime timestamp) {
        this.from = from;
        this.to = to;
        this.employeeRating = employeeRating;
        this.type = type;
        this.text = text;
        this.read = false;
        this.timestamp = timestamp;
        this.deleted = false;
    }

    Notification(User from, User to, EmployerRating employerRating, String type, String text, LocalDateTime timestamp) {
        this.from = from;
        this.to = to;
        this.employerRating = employerRating;
        this.type = type;
        this.text = text;
        this.read = false;
        this.timestamp = timestamp;
        this.deleted = false;
    }


    Notification(User from, User to, Report report, String type, String text, LocalDateTime timestamp) {
        this.from = from;
        this.to = to;
        this.report = report;
        this.type = type;
        this.text = text;
        this.read = false;
        this.timestamp = timestamp;
        this.deleted = false;
    }

    Notification(User from, User to, String type, String text, LocalDateTime timestamp) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.text = text;
        this.read = false;
        this.timestamp = timestamp;
        this.deleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public EmployeeRating getEmployeeRating() {
        return employeeRating;
    }

    public void setEmployeeRating(EmployeeRating employeeRating) {
        this.employeeRating = employeeRating;
    }

    public EmployerRating getEmployerRating() {
        return employerRating;
    }

    public void setEmployerRating(EmployerRating employerRating) {
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

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
