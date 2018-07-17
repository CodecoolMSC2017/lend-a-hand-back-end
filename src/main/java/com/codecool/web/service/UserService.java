package com.codecool.web.service;

import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
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
        return userRepository.findById(id);
    }

    public void registerUser(String email, String userName, String type, String password) throws UserAlreadyRegisteredException {
        if (userRepository.findByEmail(email) != null) {
            throw new UserAlreadyRegisteredException();
        }
        userDetailsManager.createUser(new org.springframework.security.core.userdetails.User(
            userName,
            passwordEncoder.encode(password),
            AuthorityUtils.createAuthorityList("USER")));
        User user = userRepository.findByUserName(userName);
        user.setType(type);
        user.setEmail(email);
        userRepository.save(user);
    }


    public User loginUser(String email, String password) throws UserNotFoundException, WrongPasswordException {
        if (userRepository.findByEmail(email) != null) {
            String encodedPassword = passwordEncoder.encode(password);
            if (userRepository.findByEmailAndPassword(email, encodedPassword) != null) {
                return userRepository.findByEmailAndPassword(email, encodedPassword);
            }
            throw new WrongPasswordException();
        }
        throw new UserNotFoundException();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUserData(User user) {
        userRepository.save(user);
        return user;
    }
}
