package com.codecool.web;

import com.codecool.web.dto.AdDto;
import com.codecool.web.dto.ApplicationDto;
import com.codecool.web.dto.MessageDto;
import com.codecool.web.model.*;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.*;

public class Utility {

    public static BigDecimal evaluateEmployeeRating(User user) {
        int numOfRatings = user.getEmployeeRatings().size();
        if (numOfRatings != 0) {
            double totalRatingValue = 0;
            for (EmployeeRating rating : user.getEmployeeRatings()) {
                totalRatingValue += rating.getRating();
            }
            return new BigDecimal(totalRatingValue / numOfRatings);
        } else {
            return new BigDecimal(0);
        }
    }


    public static BigDecimal evaluateEmployerRating(User user) {
        int numOfRatings = user.getEmployerRatings().size();
        if (numOfRatings != 0) {
            int totalRatingValue = 0;
            for (EmployerRating rating : user.getEmployerRatings()) {
                totalRatingValue += rating.getRating();
            }
            return new BigDecimal(totalRatingValue / numOfRatings);
        } else {
            return new BigDecimal(0);
        }
    }

    public static void sendEmail(User user) {

        final String username = "lendahand.contact@gmail.com";
        final String password = "Jancsika13";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
        try {
            javax.mail.Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("reminder.myschedule@gmail.com"));
            message.setRecipients(javax.mail.Message.RecipientType.TO,
                InternetAddress.parse(user.getEmail()));
            message.setSubject("Account verification");
            message.setText(String.format("Dear %s,\n\nYou are successfully registered to the Lend a hand website.\n\nYou must verificate your account using the code below.\n\nVerification code: %s ", user.getUserName(), user.getVerificationCode()));
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    public static List<AdDto> convertAdListtoAdDtoList(List<Ad> ads) {
        List<AdDto> adDtos = new ArrayList<>();
        for (Ad ad : ads) {
            adDtos.add(new AdDto(ad));
        }
        return adDtos;
    }
    public static List<MessageDto> convertMessageListtoMessageDtoList(List<Message> messages) {
        List<MessageDto> messageDtos = new ArrayList<>();
        for (Message message : messages) {
            messageDtos.add(new MessageDto(message));
        }
        return messageDtos;
    }


    public static List<ApplicationDto> convertApplicationListToApplicationDtoList(List<com.codecool.web.model.Application> applications) {
        List<ApplicationDto> appDtos = new ArrayList<>();
        for (com.codecool.web.model.Application app : applications) {
            appDtos.add(new ApplicationDto(app));
        }
        return appDtos;
    }

    public static List<com.codecool.web.model.Application> changeStateOfApplicaions(List<com.codecool.web.model.Application> applications, String state) {
        for (com.codecool.web.model.Application app : applications) {
            app.setState(state);
        }
        return applications;
    }

    public static Set<User> convertMessagesToUserSet(List<Message> messages, int userId) {
        Set<User> users = new HashSet<>();
        for (Message message : messages) {
            if (message.getReceiver().getId() != userId) {
                users.add(message.getReceiver());
            }
            if (message.getSender().getId() != userId) {
                users.add(message.getSender());
            }
        }
        return users;
    }
}
