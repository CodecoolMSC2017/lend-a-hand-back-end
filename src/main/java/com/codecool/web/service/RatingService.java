package com.codecool.web.service;

import com.codecool.web.dto.RatingTransferObject;
import com.codecool.web.model.EmployeeRating;
import com.codecool.web.model.EmployerRating;
import com.codecool.web.repository.EmployeeRatingRepository;
import com.codecool.web.repository.EmployerRatingRepository;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingService {

    @Autowired
    private EmployeeRatingRepository employeeRatingRepository;
    @Autowired
    private EmployerRatingRepository employerRatingRepository;
    @Autowired
    private UserRepository uRepo;

    public List<EmployeeRating> getAllEmployeeRating() {
        return employeeRatingRepository.findAll();
    }

    public List<RatingTransferObject> getAllEmployeeRatingByRaterId(int id) {
        return employeeRatingIntoTransfer(employeeRatingRepository.findAllByRater_Id(id));
    }

    public List<RatingTransferObject> getAllEmployeeRatingByRatedId(int id) {
        return employeeRatingIntoTransfer(employeeRatingRepository.findAllByRated_Id(id));
    }

    public List<EmployerRating> getAllEmployerRating() {
        return employerRatingRepository.findAll();
    }

    public List<RatingTransferObject> getAllEmployerRatingByRaterId(int id) {
        return employerRatingIntoTransfer(employerRatingRepository.findAllByRater_Id(id));
    }

    private List<RatingTransferObject> employeeRatingIntoTransfer(List<EmployeeRating> fromList){
        List<RatingTransferObject> rtoList = new ArrayList<>();

        for (EmployeeRating er : fromList){
            rtoList.add(new RatingTransferObject(er.getId(),er.getRater().getUserName(),er.getRated().getUserName(),er.getRating()));
        }

        return rtoList;

    }

    private List<RatingTransferObject> employerRatingIntoTransfer(List<EmployerRating> fromList){
        List<RatingTransferObject> rtoList = new ArrayList<>();

        for (EmployerRating er : fromList){
            rtoList.add(new RatingTransferObject(er.getId(),er.getRater().getUserName(),er.getRated().getUserName(),er.getRating()));
        }

        return rtoList;

    }

    public List<RatingTransferObject> getAllEmployerRatingByRatedId(int id) {
        return employerRatingIntoTransfer(employerRatingRepository.findAllByRated_Id(id));
    }

}
