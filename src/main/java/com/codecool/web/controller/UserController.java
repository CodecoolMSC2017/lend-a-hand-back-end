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

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/register",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody User user) {
        try {
            service.registerUser(user);
            return "You are succesfully registered";
        } catch (UserAlreadyRegisteredException ex) {
            return "Email already exists";
        }
    }

    @PostMapping(path = "/login",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody User user) {
        try {
            service.loginUser(user.getEmail(), user.getPassword());
            return "You are succesfully logged in";
        } catch (WrongPasswordException e) {
            return "Wrong password";
        } catch (UserNotFoundException ex) {
            return "User with the given email not found";
        }
    }
}
