package com.codecool.web.service;

import com.codecool.web.Utility;
import com.codecool.web.exception.NotEnoughBalanceForPremiumException;
import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.WrongVerificationCodeException;
import com.codecool.web.model.Notification;
import com.codecool.web.model.NotificationBuilder;
import com.codecool.web.model.User;
import com.codecool.web.repository.NotificationRepository;
import com.codecool.web.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private NotificationRepository notificationRepository;


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
        logger.info(user.getUserName() + " has been verificated");
        return user;
    }

    public void resendEmail(String userName) {
        User user = userRepository.findByUserName(userName);
        String verificationCode = UUID.randomUUID().toString().substring(0, 8);
        user.setVerificationCode(verificationCode);
        userRepository.save(user);
        Utility.sendEmail(user);
        logger.info("Verification email for " + user.getUserName() + " has been resend");
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
        registeredUser.setHasPaid(false);
        Utility.sendEmail(registeredUser);
        registeredUser.setType(type);
        userRepository.save(registeredUser);
        logger.info("User " + registeredUser.getUserName() + " with ID " + registeredUser.getId() + " has registered successfully");
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
        logger.info("User with ID " + id + " has been deleted");
    }

    public User updateUserData(int id, String fullName, String phone, String postalCode, String city, String address) {
        User savedUser = userRepository.findById(id);
        savedUser.setFullName(fullName);
        savedUser.setPhone(phone);
        savedUser.setPostalCode(postalCode);
        savedUser.setCity(city);
        savedUser.setAddress(address);
        savedUser.setAbleToAd(true);
        logger.info("User with ID " + id + " has been updated");
        return userRepository.save(savedUser);
    }

    public User setCompanyPaidToTrue(int userId) {
        User user = userRepository.findById(userId);
        user.setHasPaid(true);
        return userRepository.save(user);
    }

    public User updateUserBalance(int userId, int value) throws NotEnoughBalanceForPremiumException {
        User user = userRepository.findById(userId);
        if (value>0) {
            user.setBalance(user.getBalance() + value);
            user.setHasPaid(true);
        } else if (value<0 && user.getBalance() >= (Math.abs(value))) {
            user.setBalance(user.getBalance() + value);
            user.setHasPaid(true);
        } else {
            throw new NotEnoughBalanceForPremiumException();
        }
        logger.info("The balance of user with ID " + userId + " has been updated");
        return userRepository.save(user);
    }

    public User blockUser(int id) {
        User user = userRepository.findById(id);

        user.setBlocked(true);
        user.setAds(Utility.changeStateOfAds(user.getAds(), "Blocked"));
        userRepository.save(user);

        Notification blockNotification = NotificationBuilder.createBlockUserNotification(user, user);
        notificationRepository.save(blockNotification);

        return user;
    }

    public User unblockUser(int id) {
        User user = userRepository.findById(id);

        user.setBlocked(false);
        user.setAds(Utility.changeStateOfAds(user.getAds(), "Pending"));
        userRepository.save(user);

        Notification unblockNotification = NotificationBuilder.createUnblockUserNotification(user, user);
        notificationRepository.save(unblockNotification);

        return user;
    }
}
