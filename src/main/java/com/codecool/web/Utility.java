package com.codecool.web;

import com.codecool.web.model.EmployeeRating;
import com.codecool.web.model.EmployerRating;
import com.codecool.web.model.User;

import java.math.BigDecimal;

public class Utility {

    public static BigDecimal evaluateEmployeeRating(User user) {
        int numOfRatings = user.getEmployeeRatings().size();
        if (numOfRatings != 0) {
            double totalRatingValue = 0;
            for (EmployeeRating rating : user.getEmployeeRatings()) {
                totalRatingValue += rating.getRating();
            }
            return new BigDecimal(totalRatingValue / numOfRatings);
        } else {
            return new BigDecimal(0);
        }
    }


    public static BigDecimal evaluateEmployerRating(User user) {
        int numOfRatings = user.getEmployerRatings().size();
        if (numOfRatings != 0) {
            int totalRatingValue = 0;
            for (EmployerRating rating : user.getEmployerRatings()) {
                totalRatingValue += rating.getRating();
            }
            return new BigDecimal(totalRatingValue / numOfRatings);
        } else {
            return new BigDecimal(0);
        }
    }
}
