package com.codecool.web.repository;

import com.codecool.web.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findAll();

    Application findById(int id);

    List<Application> findAllByApplicant_IdOrderByTimestampDesc(int id);

    List<Application> findAllByAd_IdOrderByTimestampAsc(int id);

}
