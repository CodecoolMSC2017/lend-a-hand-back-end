package com.codecool.web.controller;

import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
            return "You are successfully registered";
        } catch (UserAlreadyRegisteredException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "You are already registered, please log in!");
        }
    }

    @PostMapping(path = "/login",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody User user) {
        try {
            User loggedUser = service.loginUser(user.getEmail(), user.getPassword());
            return loggedUser;
        } catch (WrongPasswordException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Wrong Password");
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
    }
}
