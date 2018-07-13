package com.codecool.web.service;

import com.codecool.web.exception.EmptyFieldLeftException;
import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public void registerUser(User user) throws UserAlreadyRegisteredException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyRegisteredException();
        }
        userRepository.save(user);
    }

    public User loginUser(String email, String password) throws UserNotFoundException, WrongPasswordException {
        if (userRepository.findByEmail(email) != null) {
            if (userRepository.findByEmailAndPassword(email, password) != null) {
                return userRepository.findByEmailAndPassword(email, password);
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
