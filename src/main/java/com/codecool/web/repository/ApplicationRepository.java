package com.codecool.web.repository;

import com.codecool.web.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Override
    List<Application> findAll();

    Application findById(int id);
