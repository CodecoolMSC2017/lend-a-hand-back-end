package com.codecool.web.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_id")
    @NotNull
    private Ad ad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "applicant_id")
    @NotNull
    private User applicant;

    private String message;

    @NotNull
    private LocalDateTime timestamp;

    public Application(@NotNull Ad ad, @NotNull User applicant, @NotNull LocalDateTime timestamp) {
        this.ad = ad;
        this.applicant = applicant;
        this.timestamp = timestamp;
    }

    public Application(@NotNull Ad ad, @NotNull User applicant, String message, @NotNull LocalDateTime timestamp) {
        this.ad = ad;
        this.applicant = applicant;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public Ad getAd() {
        return ad;
    }

    public User getApplicant() {
        return applicant;
    }

    public String getMessage() {
        return message;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
