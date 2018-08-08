package com.codecool.web.dto;

import com.codecool.web.model.Message;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageDto implements Serializable {

    private int id;
    private int senderId;
    private int receiverId;
    private String text;
    private LocalDateTime timestamp;
    private int adId;
    private String adTitle;

    public MessageDto() {

    }

    public MessageDto(Message message) {
        this.id = message.getId();
        this.senderId = message.getSender().getId();
        this.receiverId = message.getReceiver().getId();
        this.text = message.getText();
        this.timestamp = message.getTimestamp();
        this.adId = message.getAd().getId();
        this.adTitle = message.getAd().getTitle();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }
}

