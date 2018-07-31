package com.codecool.web.dto;

import com.codecool.web.model.EmployeeRating;
import com.codecool.web.model.EmployerRating;
import java.io.Serializable;
import java.util.List;

public class RatingDto implements Serializable {

    private List<EmployeeRating> employeeRatings;
    private List<EmployerRating> employerRatings;


    public RatingDto(List<EmployeeRating> employeeRatings, List<EmployerRating> employerRatings) {
        this.employeeRatings = employeeRatings;
        this.employerRatings = employerRatings;
    }

    public List<EmployeeRating> getEmployeeRatings() {
        return employeeRatings;
    }

    public void setEmployeeRatings(List<EmployeeRating> employeeRatings) {
        this.employeeRatings = employeeRatings;
    }

    public List<EmployerRating> getEmployerRatings() {
        return employerRatings;
    }

    public void setEmployerRatings(List<EmployerRating> employerRatings) {
        this.employerRatings = employerRatings;
    }
}
