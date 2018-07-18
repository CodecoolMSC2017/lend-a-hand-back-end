package com.codecool.web.controller;

import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public User get(Principal principal) {
        return userService.getUserbyUserName(principal.getName());
    }

    @DeleteMapping("")
    public void delete(HttpSession session) {
        session.invalidate();
    }
}
