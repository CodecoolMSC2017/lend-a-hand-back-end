package com.codecool.web.repository;

import com.codecool.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
    User findById(int id);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}
