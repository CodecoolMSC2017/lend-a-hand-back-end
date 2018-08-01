package com.codecool.web.dto;

public class RatingTransferObject {
    private int id;
    private String raterName;
    private String ratedName;
    private int rating;

    public RatingTransferObject(int id, String raterName, String ratedName, int rating) {
        this.id = id;
        this.raterName = raterName;
        this.ratedName = ratedName;
        this.rating = rating;
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
}
