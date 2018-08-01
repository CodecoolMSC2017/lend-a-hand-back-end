package com.codecool.web.dto;

import com.codecool.web.model.EmployeeRating;
import com.codecool.web.model.EmployerRating;
import java.io.Serializable;
import java.util.List;

public class RatingDto implements Serializable {

    private List<RatingTransferObject> employeeRatings;
    private List<RatingTransferObject> employerRatings;


    public RatingDto(List<RatingTransferObject> employeeRatings, List<RatingTransferObject> employerRatings) {
        this.employeeRatings = employeeRatings;
        this.employerRatings = employerRatings;
    }

    public List<RatingTransferObject> getEmployeeRatings() {
        return employeeRatings;
    }

    public List<RatingTransferObject> getEmployerRatings() {
        return employerRatings;
    }


    public void setEmployeeRatings(List<RatingTransferObject> employeeRatings) {
        this.employeeRatings = employeeRatings;
    }

    public void setEmployerRatings(List<RatingTransferObject> employerRatings) {
        this.employerRatings = employerRatings;
    }
}
