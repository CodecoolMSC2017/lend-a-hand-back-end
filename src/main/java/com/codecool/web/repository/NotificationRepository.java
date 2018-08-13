package com.codecool.web.repository;

import com.codecool.web.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    Notification findById(int id);

    List<Notification> findAllByTo_IdOrderByTimestampAsc(int userId);

    List<Notification> findAllByTo_IdAndReadFalseOrderByTimestampAsc(int userId);
}
