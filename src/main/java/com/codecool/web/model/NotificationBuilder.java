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

    public static Notification createRateNotification(User from, User to, Application application) {
        String type = "Rate";
        String text = "Dear " + to.getUserName() + ", please rate " + from.getUserName()
            + " about the ad called: " + application.getAd().getTitle() + " if you haven't already!";
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

    public static Notification createBlockAdNotification(User from, User to, Ad ad) {
        String type = "BlockAd";
        String text = "Dear " + to.getUserName() + ", your advertisement called: " + ad.getTitle() +
            " has been archieved due to inappropriate content.";
        return new Notification(from, to, ad, type, text, createTimeStamp());
    }

    // Create notification for applicants for a blocked ad
    public static Notification createBlockedAdDeclinedApplicationsNotification(User from, User to, Ad ad) {
        String type = "BlockedAdDeclinedApplications";
        String text = "Your application is automatically declined because ad: " + ad.getTitle() + " has been blocked.";
        return new Notification(from, to, ad, type, text, createTimeStamp());
    }

    public static Notification createBlockUserNotification(User from, User to) {
        String type = "BlockUser";
        String text = "Dear " + to.getUserName() + ", your account has been blocked due to inappropriate activity." +
            " You are not able to advertise or apply, and your ads are not available until your account is unblocked.";
        return new Notification(from, to, type, text, createTimeStamp());
    }

    public static Notification createUnblockUserNotification(User from, User to) {
        String type = "UnblockUser";
        String text = "Dear " + to.getUserName() + ", your account has been unblocked." +
            " You are now able to advertise or apply, and your ads are available again.";
        return new Notification(from, to, type, text, createTimeStamp());
    }

    private static LocalDateTime createTimeStamp() {
        return new Timestamp(new Date().getTime()).toLocalDateTime();
    }


}
