package com.codecool.web.controller;

import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    UserService service;

    @PostMapping(path = "/register")
    public String register(@RequestBody Map<String, String> map) throws UserAlreadyRegisteredException {
        String email = map.get("email");
        String username = map.get("userName");
        String password = map.get("password");
        String type = map.get("type");
        service.registerUser(email, username, password, type);
        return "You are successfully registered";
    }

    @PostMapping(path = "/login",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody User user) throws UserNotFoundException, WrongPasswordException {
        User loggedUser = service.loginUser(user.getEmail(), user.getPassword());
        return loggedUser;

    }
}
