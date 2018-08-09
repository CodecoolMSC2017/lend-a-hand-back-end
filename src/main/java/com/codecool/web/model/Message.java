package com.codecool.web.model;

import com.codecool.web.dto.MessageDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    @JsonBackReference(value = "user-sent-messages")
    @NotNull
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "application_id")
    @JsonBackReference(value = "application-messages")
    @NotNull
    private Application application;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver_id")
    @JsonBackReference(value = "user-received-messages")
    @NotNull
    private User receiver;

    @NotNull
    private String text;

    @NotNull
    private LocalDateTime timestamp;

    public Message() {
    }

    public Message(@NotNull User sender, @NotNull User receiver, @NotNull String text, @NotNull LocalDateTime timestamp, @NotNull Application application) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.timestamp = timestamp;
        this.application = application;
    }

    public Message(MessageDto messageDto, User sender, User receiver, Application application) {
        this.id = messageDto.getId();
        this.sender = sender;
        this.receiver = receiver;
        this.text = messageDto.getText();
        this.timestamp = messageDto.getTimestamp();
        this.application = application;
    }

    public int getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
