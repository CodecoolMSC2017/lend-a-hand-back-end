package com.codecool.web.controller;


import com.codecool.web.dto.NotificationDto;
import com.codecool.web.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping(path = "")
    public List<NotificationDto> getAllNotifications() {
        return notificationService.getAll();
    }

    @GetMapping("/{id}")
    public NotificationDto getNotificationById(@PathVariable("id") int id) {
        return notificationService.getById(id);
    }

    @GetMapping("/all/user/{userId}")
    public List<NotificationDto> getAllNotificationsByUser(@PathVariable("userId") int userId) {
        return notificationService.getNotificationsByUserId(userId);
    }

    @GetMapping("/new/{userId}")
    public boolean haveNewNotification(@PathVariable("userId") int userId) {
        return notificationService.haveNewNotification(userId);
    }

    @PutMapping("/read/{id}")
    public NotificationDto readNotification(@PathVariable("id") int id) {
        return notificationService.setReadToTrue(id);
    }

    @PutMapping("/unread/{id}")
    public NotificationDto unreadNotification(@PathVariable("id") int id) {
        return notificationService.setReadToFalse(id);
    }

    @DeleteMapping("/delete/{id}")
    public NotificationDto deleteNotification(@PathVariable("id") int id) {
        return notificationService.setDeletedToTrue(id);
    }

}
