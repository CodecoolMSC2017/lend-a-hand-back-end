package com.codecool.web.repository;

import com.codecool.web.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    Message findById(int id);

    List<Message> findAllBySender_IdAndReceiver_IdOrderByTimestampAsc(int senderId, int receiverId);

    List<Message> findDistinctBySender_IdOrReceiver_IdOrderByTimestampAsc(int senderId, int receiverId);

    List<Message> findAllBySender_IdAndReceiver_IdAndTextContainingOrderByTimestampAsc(int senderId, int receiverId, String keyword);

    List<Message> findAllByReceiver_IdAndReadFalseOrderByTimestampDesc(int receiverId);

    List<Message> findAllBySender_IdAndReceiver_IdAndTimestampGreaterThan(int senderId, int receiverId, LocalDateTime timestamp);
}
