package com.codecool.web.service;

import com.codecool.web.Utility;
import com.codecool.web.dto.ApplicationDto;
import com.codecool.web.exception.AlreadyAppliedException;
import com.codecool.web.model.*;
import com.codecool.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private NotificationRepository notificationRepository;


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

    public Application addNewApplication(ApplicationDto applicationDto) throws AlreadyAppliedException {
        if (applicationRepository.findByAd_IdAndApplicant_Id(applicationDto.getAdId(), applicationDto.getApplicantId()) != null) {
            throw new AlreadyAppliedException();
        }
        applicationDto.setTimestamp(new Timestamp(new Date().getTime()).toLocalDateTime());
        Ad ad = adRepo.findById(applicationDto.getAdId());
        User applicant = uRepo.findById(applicationDto.getApplicantId());
        //Create and save notification
        Notification notification = NotificationBuilder.createApplyNotification(applicant, ad.getAdvertiser(), ad);
        notificationRepository.save(notification);

        return applicationRepository.save(new Application(applicationDto, ad, applicant));

    }

    public List<Application> declineApplication(int id) {
        ApplicationDto applicationDto = new ApplicationDto(applicationRepository.findById(id));
        Ad ad = adRepo.findById(applicationDto.getAdId());
        User user = uRepo.findById(applicationDto.getApplicantId());
        applicationDto.setState("Declined");
        Application application = new Application(applicationDto, ad, user);
        applicationRepository.save(application);
        //Create and save notification
        Notification notification = NotificationBuilder.createDeclineNotification(ad.getAdvertiser(), user, application);
        notificationRepository.save(notification);

        return applicationRepository.findAllByAd_IdOrderByTimestampAsc(ad.getId());
    }

    private void sendAcceptanceMessage(User applicant, User advertiser, Application application) {
        LocalDateTime timestamp = new Timestamp(new Date().getTime()).toLocalDateTime();
        String initialMessage = "Dear " + applicant.getUserName() +
            ", I am interested in your application. We can discuss the details here.";
        Message message = new Message(advertiser, applicant, initialMessage, timestamp,
            application);
        messageRepository.save(message);
    }

    public List<Application> acceptApplication(int id) {
        ApplicationDto applicationDto = new ApplicationDto(applicationRepository.findById(id));
        Ad ad = adRepo.findById(applicationDto.getAdId());
        User user = uRepo.findById(applicationDto.getApplicantId());
        applicationDto.setState("Accepted");
        Application application = new Application(applicationDto, ad, user);

        //Send automatic message to applicant
        User applicant = application.getApplicant();
        User advertiser = ad.getAdvertiser();
        sendAcceptanceMessage(applicant, advertiser, application);

        //Create and save notification
        Notification notification = NotificationBuilder.createAcceptedNotification(ad.getAdvertiser(), user, application);
        notificationRepository.save(notification);

        applicationRepository.save(application);
        return applicationRepository.findAllByAd_IdOrderByTimestampAsc(ad.getId());
    }

    public ApplicationDto failApplication(int id) {
        ApplicationDto applicationDto = new ApplicationDto(applicationRepository.findById(id));
        Ad ad = adRepo.findById(applicationDto.getAdId());
        User user = uRepo.findById(applicationDto.getApplicantId());
        applicationDto.setState("Failed");
        Application application = new Application(applicationDto, ad, user);

        //Create and save notification
        Notification notification = NotificationBuilder.createFailedNotification(ad.getAdvertiser(), user, application);
        notificationRepository.save(notification);

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

        //Create and save notification
        Notification notification = NotificationBuilder.createCompletedNotification(ad.getAdvertiser(), user, application);
        notificationRepository.save(notification);

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
