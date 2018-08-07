package com.codecool.web.service;

import com.codecool.web.Utility;
import com.codecool.web.dto.Contact;
import com.codecool.web.model.Message;
import com.codecool.web.model.User;
import com.codecool.web.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public List<Contact> getContactsByUserId(int userId) {
        List<Contact> contacts = new ArrayList<>();
        List<Message> messages = messageRepository.findDistinctBySender_IdOrReceiver_IdOrderByTimestampAsc(userId, userId);
        Set<User> users = Utility.convertMessagesToUserSet(messages, userId);
        for (User user : users) {
            List<Message> sentMessages = messageRepository.findAllBySender_IdAndReceiver_IdOrderByTimestampAsc(userId, user.getId());
            List<Message> receivedMessages = messageRepository.findAllBySender_IdAndReceiver_IdOrderByTimestampAsc(user.getId(), userId);
            receivedMessages.addAll(sentMessages);
            Collections.sort(receivedMessages, Comparator.comparing(Message::getTimestamp));
            Contact contact = new Contact(user, receivedMessages, receivedMessages.get(receivedMessages.size() - 1));
            contacts.add(contact);
        }
        return contacts;
    }

}
