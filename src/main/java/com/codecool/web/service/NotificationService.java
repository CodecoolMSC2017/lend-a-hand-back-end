package com.codecool.web.service;

import com.codecool.web.model.Notification;
import com.codecool.web.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotificationService {


    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Notification getById(int id) {
        return notificationRepository.findById(id);
    }

    public Notification setReadToTrue(int id) {
        Notification notification = getById(id);
        notification.setRead(true);
        notificationRepository.save(notification);
        return notification;
    }

    public List<Notification> getNotificationsByUserId(int id) {
        return notificationRepository.findAllByTo_IdOrderByTimestampAsc(id);
    }

    public List<Notification> getAllUnreadNotificationsByUserId(int id) {
        return notificationRepository.findAllByTo_IdAndReadFalseOrderByTimestampAsc(id);
    }

}
