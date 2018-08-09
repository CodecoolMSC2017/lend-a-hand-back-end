package com.codecool.web.dto;

import com.codecool.web.model.Application;

public class RatingTransferObject {
    private int id;
    private String raterName;
    private String ratedName;
    private int rating;
    private String ratingText;
    private Application application;

    public RatingTransferObject(int id, String raterName, String ratedName, int rating, String ratingText, Application application) {
        this.id = id;
        this.raterName = raterName;
        this.ratedName = ratedName;
        this.rating = rating;
        this.ratingText = ratingText;
        this.application = application;
    }

    public int getId() {
        return id;
    }

    public String getRaterName() {
        return raterName;
    }

    public String getRatedName() {
        return ratedName;
    }

    public int getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRaterName(String raterName) {
        this.raterName = raterName;
    }

    public void setRatedName(String ratedName) {
        this.ratedName = ratedName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
