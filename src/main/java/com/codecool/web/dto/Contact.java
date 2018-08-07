package com.codecool.web.dto;

import com.codecool.web.model.Message;
import com.codecool.web.model.User;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {
    private User user;
    private List<Message> messages;
    private Message lastMessage;

    public Contact(User user, List<Message> messages, Message lastMessage) {
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }
}
