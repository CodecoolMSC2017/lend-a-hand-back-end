package com.codecool.web.service;

import com.codecool.web.model.Application;
import com.codecool.web.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    public Application getById(int id) {
        return applicationRepository.findById(id);
    }

    public List<Application> getAllByApplicantIdOrderByTimestampDesc(int id) {
        return applicationRepository.findAllByApplicant_IdOrderByTimestampDesc(id);
    }

    public List<Application> getAllByAdIdOrderByTimestampAsc(int id) {
        return applicationRepository.findAllByAd_IdOrderByTimestampAsc(id);
    }

    public Application addNewApplication(Application application) {
        applicationRepository.save(application);
        return application;
    }

    public void deleteApplication(int id) {
        applicationRepository.deleteById(id);
    }

    public Application updateApplicationData(Application application) {
        applicationRepository.save(application);
        return application;
    }

}
