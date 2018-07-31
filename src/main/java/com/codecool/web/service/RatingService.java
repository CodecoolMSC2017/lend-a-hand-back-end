package com.codecool.web.service;

import com.codecool.web.model.EmployeeRating;
import com.codecool.web.model.EmployerRating;
import com.codecool.web.repository.EmployeeRatingRepository;
import com.codecool.web.repository.EmployerRatingRepository;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public List<EmployeeRating> getAllEmployeeRatingByRaterId(int id) {
        return employeeRatingRepository.findAllByRater_Id(id);
    }

    public List<EmployeeRating> getAllEmployeeRatingByRatedId(int id) {
        return employeeRatingRepository.findAllByRated_Id(id);
    }

    public List<EmployerRating> getAllEmployerRating() {
        return employerRatingRepository.findAll();
    }

    public List<EmployerRating> getAllEmployerRatingByRaterId(int id) {
        return employerRatingRepository.findAllByRater_Id(id);
    }

    public List<EmployerRating> getAllEmployerRatingByRatedId(int id) {
        return employerRatingRepository.findAllByRated_Id(id);
    }

}
