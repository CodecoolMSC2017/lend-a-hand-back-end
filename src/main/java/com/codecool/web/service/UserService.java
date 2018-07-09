package com.codecool.web.service;

import com.codecool.web.exception.*;
import com.codecool.web.model.User;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get() method can throw error
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public void registerUser(User user) throws UserAlreadyRegisteredException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyRegisteredException();
        }
        userRepository.save(user);
    }

    public User loginUser(String email, String password) throws UserNotFoundException, WrongPasswordException {
        if(userRepository.findByEmail(email) != null) {
            if(userRepository.findByEmailAndPassword(email, password) != null) {
                return userRepository.findByEmailAndPassword(email, password);
            }
            throw new WrongPasswordException();
        }
        throw new UserNotFoundException();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUserName(int id, String userName) {
        User user = getUserById(id);
        user.setUserName(userName);
        userRepository.save(user);
        return user;
    }

    public User updateEmail(int id, String email) {
        User user = getUserById(id);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    public User updatePassword(int id, String password) {
        User user = getUserById(id);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }

    public User updateUserData(int id, String fullName, String phone, String postalCode, String city, String address) throws EmptyFieldLeftException {
        if (fullName != null && phone != null && postalCode != null && city != null && address != null) {
            User user = getUserById(id);
            user.setFullName(fullName);
            user.setPhone(phone);
            user.setPostalCode(postalCode);
            user.setCity(city);
            user.setAddress(address);
            user.setAbleToAd(true);
            userRepository.save(user);
            return user;
        }
        throw new EmptyFieldLeftException();
    }
}
