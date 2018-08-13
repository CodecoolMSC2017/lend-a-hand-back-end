package com.codecool.web.service;

import com.codecool.web.Utility;
import com.codecool.web.dto.AdDto;
import com.codecool.web.dto.ApplicationDto;
import com.codecool.web.dto.Contact;
import com.codecool.web.dto.MessageDto;
import com.codecool.web.model.Application;
import com.codecool.web.model.Message;
import com.codecool.web.model.User;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.ApplicationRepository;
import com.codecool.web.repository.MessageRepository;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;

@Component
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Message> getAllBySender_IdAndReceiver_IdOrderByTimestampAsc(int senderId, int receiverId) {
        return messageRepository.findAllBySender_IdAndReceiver_IdOrderByTimestampAsc(senderId, receiverId);
    }

    public List<Message> getAllBySender_IdAndReceiver_IdAndTextContainingOrderByTimestampAsc(int senderId, int receiverId, String keyword) {
        return messageRepository.findAllBySender_IdAndReceiver_IdAndTextContainingOrderByTimestampAsc(senderId, receiverId, keyword);
    }

    public MessageDto addNewMessage(MessageDto messageDto) {
        User sender = userRepository.findById(messageDto.getSenderId());
        User receiver = userRepository.findById(messageDto.getReceiverId());
        Application application = applicationRepository.findById(messageDto.getApplicationId());
        messageDto.setTimestamp(new Timestamp(new Date().getTime()).toLocalDateTime());
        Message message = new Message(messageDto, sender, receiver, application);
        messageRepository.save(message);
        return new MessageDto(message);
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
            List<MessageDto> messageDtos = Utility.convertMessageListtoMessageDtoList(receivedMessages);
            AdDto ad = new AdDto(receivedMessages.get(receivedMessages.size() - 1).getApplication().getAd());
            ApplicationDto application = new ApplicationDto(receivedMessages.get(receivedMessages.size() - 1).getApplication());
            Contact contact = new Contact(user, messageDtos, messageDtos.get(messageDtos.size() - 1), ad, application);
            contacts.add(contact);
        }
        Collections.sort(contacts, (o1, o2) -> o2.getLastMessage().getTimestamp().compareTo(o1.getLastMessage().getTimestamp()));
        return contacts;
    }


    public boolean isContactedWithUser(int userId, int profileOwnerId) {
        List<Contact> contacts = getContactsByUserId(userId);
        for (Contact contact : contacts) {
            if (contact.getUser().getId() == profileOwnerId) {
                return true;
            }
        }
        return false;
    }

}
