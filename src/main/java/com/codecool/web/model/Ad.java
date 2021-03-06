package com.codecool.web.model;

import com.codecool.web.dto.AdDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference(value = "user-ads")
    @JoinColumn(name = "advertiser_id")
    @NotNull
    private User advertiser;


    @OneToMany(mappedBy = "ad")
    @JsonManagedReference(value = "ad-applications")
    private List<Application> applications;

    @NotNull
    @Size(max = 64)
    private String title;

    @NotNull
    private String description;

    @Column(name = "picture_link")
    private String pictureLink;

    private int payment;

    @NotNull
    @Size(max = 32)
    private String category;

    @Column(name = "is_premium")
    private boolean isPremium;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private String type;

    @NotNull
    private String state;

    public Ad() {
    }

    public Ad(@NotNull User advertiser, @NotNull @Size(max = 64) String title, @NotNull String description, @NotNull @Size(max = 32) String category, boolean isPremium, @NotNull LocalDateTime timestamp, @NotNull String type, @NotNull String state) {
        this.advertiser = advertiser;
        this.title = title;
        this.description = description;
        this.category = category;
        this.isPremium = isPremium;
        this.timestamp = timestamp;
        this.type = type;
        this.state = state;
    }

    public Ad(@NotNull User advertiser, List<Application> applications, @NotNull @Size(max = 64) String title, @NotNull String description, String pictureLink, int payment, @NotNull @Size(max = 32) String category, boolean isPremium, @NotNull LocalDateTime timestamp, @NotNull String type, @NotNull String state) {
        this.advertiser = advertiser;
        this.applications = applications;
        this.title = title;
        this.description = description;
        this.pictureLink = pictureLink;
        this.payment = payment;
        this.category = category;
        this.isPremium = isPremium;
        this.timestamp = timestamp;
        this.type = type;
        this.state = state;
    }

    public Ad(AdDto adDto, User user) {
        this.advertiser = user;
        this.title = adDto.getTitle();
        this.description = adDto.getDescription();
        this.category = adDto.getCategory();
        this.isPremium = adDto.getIsPremium();
        this.payment = adDto.getPayment();
        this.timestamp = adDto.getTimestamp();
        this.type = adDto.getType();
        this.pictureLink = adDto.getPictureLink();
        this.state = adDto.getState();
    }

    public int getId() {
        return id;
    }

    public User getAdvertiser() {
        return advertiser;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPayment() {
        return payment;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public String getCategory() {
        return category;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setAdvertiser(User advertiser) {
        this.advertiser = advertiser;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
