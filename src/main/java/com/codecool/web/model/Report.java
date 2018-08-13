package com.codecool.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "sent-user-reports")
    @JoinColumn(name = "reporter_id")
    @NotNull
    private User reporter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "got-user-reports")
    @JoinColumn(name = "reported_user_id")
    private User reportedUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "ad-reports")
    @JoinColumn(name = "reported_ad_id")
    private Ad reportedAd;

    @Column(name = "report_text")
    private String reportText;

    public Report() {
    }

    public Report(@NotNull User reporter, User reportedUser, Ad reportedAd, String reportText) {
        this.reporter = reporter;
        this.reportedUser = reportedUser;
        this.reportedAd = reportedAd;
        this.reportText = reportText;
    }

    public int getId() {
        return id;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getReportedUser() {
        return reportedUser;
    }

    public void setReportedUser(User reportedUser) {
        this.reportedUser = reportedUser;
    }

    public Ad getReportedAd() {
        return reportedAd;
    }

    public void setReportedAd(Ad reportedAd) {
        this.reportedAd = reportedAd;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }
}
