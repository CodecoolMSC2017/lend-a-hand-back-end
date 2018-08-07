package com.codecool.web.dto;

import com.codecool.web.model.Message;
import com.codecool.web.model.User;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {
    private User user;
    private List<MessageDto> messages;
    private MessageDto lastMessage;

    public Contact(User user, List<MessageDto> messages, MessageDto lastMessage) {
        this.user = user;
        this.messages = messages;
        this.lastMessage = lastMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    public MessageDto getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(MessageDto lastMessage) {
        this.lastMessage = lastMessage;
    }
}
