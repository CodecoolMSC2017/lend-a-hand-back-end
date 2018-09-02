package com.codecool.web.service;

import com.codecool.web.dto.*;
import com.codecool.web.model.*;
import com.codecool.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private EmployeeRatingRepository employeeRatingRepository;

    @Autowired
    private EmployerRatingRepository employerRatingRepository;

    @Autowired
    private ReportRepository reportRepository;


    public List<NotificationDto> getAll() {
        return convertNotificationListToNotificationDtoList(notificationRepository.findAll());
    }

    public NotificationDto getById(int id) {
        return createNotificationDto(notificationRepository.findById(id));
    }

    public NotificationDto setReadToTrue(int id) {
        Notification notification = notificationRepository.findById(id);
        notification.setRead(true);
        notificationRepository.save(notification);
        return createNotificationDto(notification);
    }

    public NotificationDto setReadToFalse(int id) {
        Notification notification = notificationRepository.findById(id);
        notification.setRead(false);
        notificationRepository.save(notification);
        return createNotificationDto(notification);
    }

    public List<NotificationDto> getNotificationsByUserId(int id) {
        List<Notification> notifications = notificationRepository.findAllByTo_IdAndDeletedFalseOrderByTimestampDesc(id);
        return convertNotificationListToNotificationDtoList(notifications);
    }

    private List<Notification> getAllUnreadNotificationsByUserId(int id) {
        return notificationRepository.findAllByTo_IdAndReadFalseOrderByTimestampDesc(id);
    }

    public boolean haveNewNotification(int id) {
        return getAllUnreadNotificationsByUserId(id).isEmpty();
    }

    public NotificationDto setDeletedToTrue(int id) {
        Notification notification = notificationRepository.findById(id);
        notification.setDeleted(true);
        notification.setRead(true);
        notificationRepository.save(notification);
        return createNotificationDto(notification);
    }


    private List<NotificationDto> convertNotificationListToNotificationDtoList(List<Notification> notifications) {
        List<NotificationDto> notificationDtos = new ArrayList<>();
        for (Notification notification : notifications) {
            notificationDtos.add(createNotificationDto(notification));
        }
        return notificationDtos;
    }

    private NotificationDto createNotificationDto(Notification notification) {
        AdDto adDto = null;
        ApplicationDto applicationDto = null;
        RatingTransferObject employeeRatingDto = null;
        RatingTransferObject employerRatingDto = null;
        ReportDto reportDto = null;
        NotificationDto notificationDto = new NotificationDto(notification);
        if (notification.getAd() != null) {
            Ad ad = notification.getAd();
            adDto = new AdDto(ad);
        }
        if (notification.getApplication() != null) {
            Application application = notification.getApplication();
            applicationDto = new ApplicationDto(application);
        }
        if (notification.getEmployeeRating() != null) {
            EmployeeRating employeeRating = notification.getEmployeeRating();
            Application application = employeeRating.getApplication();
            ApplicationDto empApplicationDto = new ApplicationDto(application);
            employeeRatingDto = new RatingTransferObject(employeeRating, empApplicationDto);
        }
        if (notification.getEmployerRating() != null) {
            EmployerRating employerRating = notification.getEmployerRating();
            Application application = employerRating.getApplication();
            ApplicationDto empApplicationDto = new ApplicationDto(application);
            employerRatingDto = new RatingTransferObject(employerRating, empApplicationDto);
        }
        if (notification.getReport() != null) {
            Report report = notification.getReport();
            reportDto = new ReportDto(report);
        }
        notificationDto.setAd(adDto);
        notificationDto.setApplication(applicationDto);
        notificationDto.setEmployeeRating(employeeRatingDto);
        notificationDto.setEmployerRating(employerRatingDto);
        notificationDto.setReport(reportDto);
        return notificationDto;
    }

}
