package com.codecool.web.service;

import com.codecool.web.Utility;
import com.codecool.web.dto.ApplicationDto;
import com.codecool.web.exception.AlreadyAppliedException;
import com.codecool.web.model.*;
import com.codecool.web.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationService.class);

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
        logger.info(applicant.getUserName() + " has created a new application for the advertisement " + ad.getTitle() + " with ID " + ad.getId());
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
        logger.info(user.getUserName() + " has declined the application of " + application.getApplicant().getUserName() + " for the advertisement with ID " + ad.getId());
        return applicationRepository.findAllByAd_IdOrderByTimestampAsc(ad.getId());
    }

    private void sendAcceptanceMessage(User applicant, User advertiser, Application application) {
        LocalDateTime timestamp = new Timestamp(new Date().getTime()).toLocalDateTime();
        String initialMessage = "Dear " + applicant.getUserName() +
            ", I am interested in your application. We can discuss the details here.";
        Message message = new Message(advertiser, applicant, initialMessage, timestamp,
            application, false);
        messageRepository.save(message);
        logger.info("Automatic message from " + advertiser.getUserName() + " to " + applicant.getUserName() + " after accepting the application with ID " + application.getId());
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
        logger.info(user.getUserName() + " has accepted the application of " + application.getApplicant().getUserName() + " for the advertisement with ID " + ad.getId());
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

        notification = NotificationBuilder.createRateNotification(user, ad.getAdvertiser(), application);
        notificationRepository.save(notification);

        applicationRepository.save(application);
        logger.info(user.getUserName() + " has marked the application of " + application.getApplicant().getUserName() + " for the advertisement with ID " + ad.getId() + "as 'Failed'");
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

        notification = NotificationBuilder.createRateNotification(user, ad.getAdvertiser(), application);
        notificationRepository.save(notification);

        applicationRepository.save(application);
        adRepo.save(ad);
        logger.info(user.getUserName() + " has marked the application of " + application.getApplicant().getUserName() + " for the advertisement with ID " + ad.getId() + "as 'Completed'. Every other applications for this ad have marked as 'Declined'");
        return new ApplicationDto(applicationRepository.findById(application.getId()));
    }


    public void deleteApplication(int id) {
        applicationRepository.deleteById(id);
        logger.info("The application with ID " + id + " has been deleted");
    }

    public Application updateApplicationData(Application application) {
        applicationRepository.save(application);
        logger.info("The application with ID " + application.getId() + " has been updated");
        return application;
    }

    public boolean isUserAppliedToAd(int userId, int adId) {
        List<Application> applicationsAtAd = getAllByAdIdOrderByTimestampAsc(adId);
        for (Application application : applicationsAtAd) {
            if (application.getApplicant().getId() == userId) {
                return true;
            }
        }
        return false;
    }

}
