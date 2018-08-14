package com.codecool.web.controller;

import com.codecool.web.model.User;
import com.codecool.web.service.MessageService;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @GetMapping("")
    public List<User> getAllUsers() {return userService.getAllUsers();}

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    @PutMapping(path = "")
    public User updateUser(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String fullName = map.get("fullName");
        String phone = map.get("phone");
        String postalCode = map.get("postalCode");
        String city = map.get("city");
        String address = map.get("address");
        return userService.updateUserData(id, fullName, phone, postalCode, city, address);
    }

    @GetMapping(path = "/contacted")
    public boolean getIsContacted(@RequestParam(value = "userId", required = false) int userId,
                                  @RequestParam(value = "profileOwnerId", required = false) int profileOwnerId) {
        return messageService.isContactedWithUser(userId, profileOwnerId);
    }
}
