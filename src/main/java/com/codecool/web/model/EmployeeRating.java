package com.codecool.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee_ratings")
public class EmployeeRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rater_id")
    @JsonBackReference(value = "user-rated-employee")
    @NotNull
    private User rater;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rated_id")
    @JsonBackReference(value = "user-employee-rating")
    @NotNull
    private User rated;

    @NotNull
    private int rating;

    @NotNull
    @JoinColumn(name = "rating_text")
    private String ratingText;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "application_id")
    private Application application;

    public EmployeeRating() {
    }

    public EmployeeRating(@NotNull User rater, @NotNull User rated, @NotNull int rating, @NotNull String ratingText, @NotNull int applicationId) {
        this.rater = rater;
        this.rated = rated;
        this.rating = rating;
        this.ratingText = ratingText;
        this.application = application;
    }

    public int getId() {
        return id;
    }

    public User getRater() {
        return rater;
    }

    public void setRater(User rater) {
        this.rater = rater;
    }

    public User getRated() {
        return rated;
    }

    public void setRated(User rated) {
        this.rated = rated;
    }

    public int getRating() {
        return rating;
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
