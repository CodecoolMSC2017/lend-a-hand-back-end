package com.codecool.web.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class NotificationBuilder {

    public static Notification createApplyNotification(User from, User to, Ad ad) {
        String type = "Apply";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + " applied for your ad called: " + ad.getTitle();
        return new Notification(from, to, ad, type, text, createTimeStamp());
    }

    public static Notification createAcceptedNotification(User from, User to, Application application) {
        String type = "Accepted";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + " accepted your application for the ad called: " + application.getAd().getTitle();
        return new Notification(from, to, application, type, text, createTimeStamp());
    }

    public static Notification createDeclineNotification(User from, User to, Application application) {
        String type = "Declined";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + " declined your application for the ad called: " + application.getAd().getTitle();
        return new Notification(from, to, application, type, text, createTimeStamp());
    }

    public static Notification createCompletedNotification(User from, User to, Application application) {
        String type = "Completed";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + " marked your application as completed for the ad called: " + application.getAd().getTitle();
        return new Notification(from, to, application, type, text, createTimeStamp());
    }

    public static Notification createFailedNotification(User from, User to, Application application) {
        String type = "Failed";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + " marked your application as failed for the ad called: " + application.getAd().getTitle();
        return new Notification(from, to, application, type, text, createTimeStamp());
    }

    public static Notification createEmployeeRatingNotification(User from, User to, EmployeeRating employeeRating) {
        String type = "EmployeeRated";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + " submitted a rating about you as a Hand-seeker";
        return new Notification(from, to, employeeRating, type, text, createTimeStamp());
    }

    public static Notification createEmployerRatingNotification(User from, User to, EmployerRating employerRating) {
        String type = "EmployerRated";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + " submitted a rating about you as a Hand-lender";
        return new Notification(from, to, employerRating, type, text, createTimeStamp());
    }

    public static Notification createReportNotification(User from, User to, Report report) {
        String type = "Report";
        String text;
        if (report.getReportedUser() != null) {
            text = from.getUserName() + " reported user: " + report.getReportedUser().getUserName();
        } else {
            text = from.getUserName() + " reported ad: " + report.getReportedAd().getTitle();
        }
        return new Notification(from, to, report, type, text, createTimeStamp());
    }

    // Create handled report notification
    public static Notification createHandleNotification(User from, User to, Report report) {
        String type = "Handle";
        String text;
        if (report.getReportedUser() != null) {
            text = "Your report is under consideration about user: " + report.getReportedUser().getUserName();
        } else {
            text = "Your report is under consideration about ad: " + report.getReportedAd().getTitle()
                + ", from user: " + report.getReportedAd().getAdvertiser().getUserName();
        }
        return new Notification(from, to, report, type, text, createTimeStamp());
    }

    private static LocalDateTime createTimeStamp() {
        return new Timestamp(new Date().getTime()).toLocalDateTime();
    }


}
