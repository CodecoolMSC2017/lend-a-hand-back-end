package com.codecool.web.controller;

import com.codecool.web.dto.Contact;
import com.codecool.web.dto.MessageDto;
import com.codecool.web.dto.UserContactDto;
import com.codecool.web.model.Message;
import com.codecool.web.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/senders/{senderId}/receivers/{receiverId}")
    public List<Message> getAllMessagesBySenderIdAndReceiverIdId(@PathVariable("senderId") int senderId, @PathVariable("receiverId") int receiverId) {
        return messageService.getAllBySender_IdAndReceiver_IdOrderByTimestampAsc(senderId, receiverId);
    }

    @GetMapping("/senders/{senderId}/receivers/{receiverId}/keywords/{keyword}")
    public List<Message> getAllMessagesBySenderIdAndReceiverIdAndTextContaining(@PathVariable("senderId") int senderId, @PathVariable("receiverId") int receiverId, @PathVariable("keyword") String keyword) {
        return messageService.getAllBySender_IdAndReceiver_IdAndTextContainingOrderByTimestampAsc(senderId, receiverId, keyword);
    }

    @GetMapping("/contacts/{userId}")
    public List<Contact> getContacts(@PathVariable("userId") int userId) {
        return messageService.getContactsByUserId(userId);
    }

    @GetMapping("/new/{userId}")
    public boolean haveNewMessage(@PathVariable("userId") int userId) {
        return messageService.haveNewMessage(userId);
    }

    @PutMapping(path = "/read",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> readMessages(@RequestBody UserContactDto userContactDto) {
        return messageService.setReadToTrue(userContactDto);
    }

    @PostMapping(path = "/new",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageDto createNewMessage(@RequestBody MessageDto messageDto) {
        return messageService.addNewMessage(messageDto);
    }
}
