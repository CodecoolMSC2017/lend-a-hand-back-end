package com.codecool.web.service;

import com.codecool.web.Utility;
import com.codecool.web.dto.ApplicationDto;
import com.codecool.web.exception.AlreadyAppliedException;
import com.codecool.web.model.Ad;
import com.codecool.web.model.Application;
import com.codecool.web.model.User;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.ApplicationRepository;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository uRepo;

    @Autowired
    private AdRepository adRepo;


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

    public Application addNewApplication(ApplicationDto application) throws AlreadyAppliedException {
        if (applicationRepository.findByAd_IdAndApplicant_Id(application.getAdId(), application.getApplicantId()) != null) {
            throw new AlreadyAppliedException();
        }
        application.setTimestamp(new Timestamp(new Date().getTime()).toLocalDateTime());
        return applicationRepository.save(new Application(application,adRepo.findById(application.getAdId()),uRepo.findById(application.getApplicantId())));

    }

    public List<Application> declineApplication(int id) {
        ApplicationDto applicationDto = new ApplicationDto(applicationRepository.findById(id));
        Ad ad = adRepo.findById(applicationDto.getAdId());
        User user = uRepo.findById(applicationDto.getApplicantId());
        applicationDto.setState("Declined");
        Application application = new Application(applicationDto, ad, user);
        applicationRepository.save(application);
        return applicationRepository.findAllByAd_IdOrderByTimestampAsc(ad.getId());
    }

    public List<Application> acceptApplication(int id) {
        ApplicationDto applicationDto = new ApplicationDto(applicationRepository.findById(id));
        Ad ad = adRepo.findById(applicationDto.getAdId());
        User user = uRepo.findById(applicationDto.getApplicantId());
        applicationDto.setState("Accepted");
        Application application = new Application(applicationDto, ad, user);
        applicationRepository.save(application);
        return applicationRepository.findAllByAd_IdOrderByTimestampAsc(ad.getId());
    }

    public ApplicationDto failApplication(int id) {
        ApplicationDto applicationDto = new ApplicationDto(applicationRepository.findById(id));
        Ad ad = adRepo.findById(applicationDto.getAdId());
        User user = uRepo.findById(applicationDto.getApplicantId());
        applicationDto.setState("Failed");
        Application application = new Application(applicationDto, ad, user);
        applicationRepository.save(application);
        return new ApplicationDto(applicationRepository.findById(application.getId()));
    }

    public ApplicationDto completeApplication(int id) {
        ApplicationDto applicationDto = new ApplicationDto(applicationRepository.findById(id));
        Ad ad = adRepo.findById(applicationDto.getAdId());
        User user = uRepo.findById(applicationDto.getApplicantId());
        applicationDto.setState("Completed");
        ad.setState("Completed");
        ad.setApplications(Utility.changeStateOfApplicaions(ad.getApplications(), "Declined", applicationDto.getId()));
        Application application = new Application(applicationDto, ad, user);
        applicationRepository.save(application);
        adRepo.save(ad);
        return new ApplicationDto(applicationRepository.findById(application.getId()));
    }


    public void deleteApplication(int id) {
        applicationRepository.deleteById(id);
    }

    public Application updateApplicationData(Application application) {
        applicationRepository.save(application);
        return application;
    }

}
