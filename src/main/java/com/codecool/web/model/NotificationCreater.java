package com.codecool.web.model;

public class NotificationCreater {

    public static Notification createApplyNotification(User from, User to, Ad ad) {
        String type = "Apply";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + "applied for your ad called: " + ad.getTitle();
        return new Notification(from, to, ad, type, text);
    }

    public static Notification createAcceptedNotification(User from, User to, Application application) {
        String type = "Accepted";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + "accepted your application for the ad called: " + application.getAd().getTitle();
        return new Notification(from, to, application, type, text);
    }

    public static Notification createDeclineNotification(User from, User to, Application application) {
        String type = "Declined";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + "declined your application for the ad called: " + application.getAd().getTitle();
        return new Notification(from, to, application, type, text);
    }

    public static Notification createCompletedNotification(User from, User to, Application application) {
        String type = "Completed";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + "marked your application as completed for the ad called: " + application.getAd().getTitle();
        return new Notification(from, to, application, type, text);
    }

    public static Notification createFailedNotification(User from, User to, Application application) {
        String type = "Failed";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + "marked your application as failed for the ad called: " + application.getAd().getTitle();
        return new Notification(from, to, application, type, text);
    }

    public static Notification createEmployeeRatingNotification(User from, User to, EmployeeRating employeeRating) {
        String type = "EmployeeRated";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + "submitted a rating about you as a Hand-seeker";
        return new Notification(from, to, employeeRating, type, text);
    }

    public static Notification createEmployerRatingNotification(User from, User to, EmployerRating employerRating) {
        String type = "EmployerRated";
        String text = "Dear " + to.getUserName() + ", " + from.getUserName()
            + "submitted a rating about you as a Hand-lender";
        return new Notification(from, to, employerRating, type, text);
    }


}
