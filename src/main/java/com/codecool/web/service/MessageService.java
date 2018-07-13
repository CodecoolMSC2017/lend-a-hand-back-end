package com.codecool.web.service;

import com.codecool.web.model.Message;
import com.codecool.web.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllBySender_IdAndReceiver_IdOrderByTimestampAsc(int senderId, int receiverId) {
        return messageRepository.findAllBySender_IdAndReceiver_IdOrderByTimestampAsc(senderId, receiverId);
    }

    public List<Message> getAllBySender_IdAndReceiver_IdAndTextContainingOrderByTimestampAsc(int senderId, int receiverId, String keyword) {
        return messageRepository.findAllBySender_IdAndReceiver_IdAndTextContainingOrderByTimestampAsc(senderId, receiverId, keyword);
    }

    public Message addNewMessage(Message message) {
        messageRepository.save(message);
        return message;
    }

}
