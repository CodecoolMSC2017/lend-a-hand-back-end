package com.codecool.web.service;

import com.codecool.web.Utility;
import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.WrongVerificationCodeException;
import com.codecool.web.model.User;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


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
        User user = userRepository.findByUserName(username);
        user.setEmployeeRatingScore(Utility.evaluateEmployeeRating(user));
        user.setEmployerRatingScore(Utility.evaluateEmployerRating(user));
        return user;
    }

    public User verificate(String userName, String verificationCode) throws WrongVerificationCodeException {
        User user = userRepository.findByUserNameAndVerificationCode(userName, verificationCode);
        if (user == null) {
            throw new WrongVerificationCodeException();
        }
        user.setVerificated(true);
        userRepository.save(user);
        return user;
    }

    public void resendEmail(String userName) {
        User user = userRepository.findByUserName(userName);
        String verificationCode = UUID.randomUUID().toString().substring(0, 8);
        user.setVerificationCode(verificationCode);
        userRepository.save(user);
        Utility.sendEmail(user);
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

        String verificationCode = UUID.randomUUID().toString().substring(0, 8);
        registeredUser.setVerificationCode(verificationCode);
        registeredUser.setVerificated(false);
        registeredUser.setEmail(email);
        Utility.sendEmail(registeredUser);
        registeredUser.setType(type);
        userRepository.save(registeredUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUserData(int id, String fullName, String phone, String postalCode, String city, String address) {
        User savedUser = userRepository.findById(id);
        savedUser.setFullName(fullName);
        savedUser.setPhone(phone);
        savedUser.setPostalCode(postalCode);
        savedUser.setCity(city);
        savedUser.setAddress(address);
        savedUser.setAbleToAd(true);
        return userRepository.save(savedUser);
    }
}
