package com.codecool.web.service;

import com.codecool.web.dto.ApplicationDto;
import com.codecool.web.dto.RatingTransferObject;
import com.codecool.web.model.*;
import com.codecool.web.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingService {

    private static final Logger logger = LoggerFactory.getLogger(RatingService.class);
    @Autowired
    private EmployeeRatingRepository employeeRatingRepository;
    @Autowired
    private EmployerRatingRepository employerRatingRepository;
    @Autowired
    private UserRepository uRepo;
    @Autowired
    private AdRepository adRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    public List<EmployeeRating> getAllEmployeeRating() {
        return employeeRatingRepository.findAll();
    }

    public List<EmployerRating> getAllEmployerRating() {
        return employerRatingRepository.findAll();
    }

    public List<RatingTransferObject> getAllEmployeeRatingByRaterId(int id) {
        return employeeRatingIntoTransfer(employeeRatingRepository.findAllByRater_Id(id));
    }

    public List<RatingTransferObject> getAllEmployeeRatingByRatedId(int id) {
        return employeeRatingIntoTransfer(employeeRatingRepository.findAllByRated_Id(id));
    }

    public List<RatingTransferObject> getAllEmployerRatingByRatedId(int id) {
        return employerRatingIntoTransfer(employerRatingRepository.findAllByRated_Id(id));
    }


    public List<RatingTransferObject> getAllEmployerRatingByRaterId(int id) {
        return employerRatingIntoTransfer(employerRatingRepository.findAllByRater_Id(id));
    }

    public User addNewRating(RatingTransferObject ratingTransferObject) {
        User rated = uRepo.findByUserName(ratingTransferObject.getRatedName());
        User rater = uRepo.findByUserName(ratingTransferObject.getRaterName());

        //Get datas to convert applicationDto to Application
        ApplicationDto applicationDto = ratingTransferObject.getApplication();
        Ad ad = adRepository.findById(ratingTransferObject.getApplication().getAdId());
        User applicant = uRepo.findById(ratingTransferObject.getApplication().getApplicantId());
        Application application = new Application(applicationDto, ad, applicant);

        //If the applicant is the rated create object and save it
        if (applicant.getId() == rated.getId()) {
            EmployeeRating employeeRating = new EmployeeRating(rater, rated, ratingTransferObject, application);
            employeeRatingRepository.save(employeeRating);
            //Create and save notification
            Notification notification = NotificationBuilder.createEmployeeRatingNotification(rater, rated, employeeRating);
            notificationRepository.save(notification);

            logger.info(rated + " was rated as a Hand-lender by " + rater + " based on the ad with ID " + ad.getId());
            //If the advertiser is the rated create object and save it
        } else {
            EmployerRating employerRating = new EmployerRating(rater, rated, ratingTransferObject, application);
            employerRatingRepository.save(employerRating);
            //Create and save notification
            Notification notification = NotificationBuilder.createEmployerRatingNotification(rater, rated, employerRating);
            notificationRepository.save(notification);

            logger.info(rated + " was rated as a Hand-seeker by " + rater + " based on the ad with ID " + ad.getId());
        }

        //Read out the rater from database and return it
        return uRepo.findById(rater.getId());
    }

    private List<RatingTransferObject> employeeRatingIntoTransfer(List<EmployeeRating> fromList) {
        List<RatingTransferObject> rtoList = new ArrayList<>();

        for (EmployeeRating er : fromList) {
            rtoList.add(new RatingTransferObject(er, new ApplicationDto(er.getApplication())));
        }

        return rtoList;
    }

    private List<RatingTransferObject> employerRatingIntoTransfer(List<EmployerRating> fromList) {
        List<RatingTransferObject> rtoList = new ArrayList<>();

        for (EmployerRating er : fromList) {
            rtoList.add(new RatingTransferObject(er, new ApplicationDto(er.getApplication())));
        }

        return rtoList;
    }


}
