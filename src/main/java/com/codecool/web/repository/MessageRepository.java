package com.codecool.web.repository;

import com.codecool.web.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findAllBySender_IdAndReceiver_IdOrderByTimestampAsc(int senderId, int receiverId);

    List<Message> findDistinctBySender_IdOrReceiver_IdOrderByTimestampAsc(int senderId, int receiverId);
    List<Message> findAllBySender_IdAndReceiver_IdAndTextContainingOrderByTimestampAsc(int senderId, int receiverId, String keyword);
}
