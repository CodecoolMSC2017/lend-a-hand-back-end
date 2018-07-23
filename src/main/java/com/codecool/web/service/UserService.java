package com.codecool.web.service;

import com.codecool.web.Utility;
import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.model.User;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        User user = userRepository.findById(id);
        user.setEmployeeRatingScore(Utility.evaluateEmployeeRating(user));
        user.setEmployerRatingScore(Utility.evaluateEmployerRating(user));
        return user;
    }

    public User getUserbyUserName(String username) {
        return userRepository.findByUserName(username);
    }


    public void registerUser(String email, String username, String password, String type) throws UserAlreadyRegisteredException {
        if (userRepository.findByEmail(email) != null || userRepository.findByUserName(username) != null) {
            throw new UserAlreadyRegisteredException();
        }
        userDetailsManager.createUser(new org.springframework.security.core.userdetails.User(
            username,
            passwordEncoder.encode(password),
            AuthorityUtils.createAuthorityList("USER_ROLE")));
        User registeredUser = userRepository.findByUserName(username);
        registeredUser.setEmail(email);
        registeredUser.setType(type);
        userRepository.save(registeredUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUserData(User user) {
        userRepository.save(user);
        return user;
    }
}
