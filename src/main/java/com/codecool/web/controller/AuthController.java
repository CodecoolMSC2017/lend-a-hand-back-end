package com.codecool.web.controller;

import com.codecool.web.exception.WrongVerificationCodeException;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@RestController


@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public User get(Principal principal) {
        return userService.getUserbyUserName(principal.getName());
    }

    @PostMapping("/verificate")
    public User verificateEmail(@RequestBody Map<String, String> map) throws WrongVerificationCodeException {
        String userName = map.get("userName");
        String verificationCode = map.get("code");
        return userService.verificate(userName, verificationCode);
    }

    @PutMapping("/resend")
    public void resendEmail(@RequestBody Map<String, String> map) {
        String userName = map.get("userName");
        userService.resendEmail(userName);
    }

    @DeleteMapping("")
    public void delete(HttpSession session) {
        session.invalidate();
    }
}
