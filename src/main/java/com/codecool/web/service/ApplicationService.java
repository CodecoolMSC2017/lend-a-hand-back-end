package com.codecool.web.service;


import com.codecool.web.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationService {

    @Autowired
    private ApplicationService applicatonRepository;

    List<Application> findAll() {
        return applicatonRepository.findAll();
    }

    Application findById(int id) {
        return applicatonRepository.findById(id);
    }

    Application findAllByApplicant_IdOrderByTimestampDesc(int id) {
        return applicatonRepository.findAllByApplicant_IdOrderByTimestampDesc(id);
    }

    List<Application> findAllByAd_IdOrderByTimestampAsc(int id) {
        return applicatonRepository.findAllByAd_IdOrderByTimestampAsc(id);
    }

}
