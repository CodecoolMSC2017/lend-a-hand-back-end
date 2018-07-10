package com.codecool.web.controller;

import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.AbstractModel;
import com.codecool.web.model.Message;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/login")
    public AbstractModel login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            User user = service.loginUser(email, password);
            return user;
        } catch (WrongPasswordException e) {
            return new Message("Wrong password");
        } catch (UserNotFoundException ex) {
            return new Message("User with the given email not found");
        }
    }
}
