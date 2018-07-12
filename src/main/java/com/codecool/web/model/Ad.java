package com.codecool.web.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advertiser_id")
    @NotNull
    private User advertiser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chosen_applicant_id")
    private User chosenApplicant;

    @NotNull
    @Size(max = 64)
    private String title;

    @NotNull
    private String description;

    private int payment;

    @NotNull
    @Size(max = 32)
    private String category;

    @Column(name = "is_premium")
    private boolean isPremium;

    public Ad(@NotNull User advertiser, @NotNull @Size(max = 64) String title, @NotNull String description, @NotNull @Size(max = 32) String category, boolean isPremium) {
        this.advertiser = advertiser;
        this.title = title;
        this.description = description;
        this.category = category;
        this.isPremium = isPremium;
    }

    public Ad(@NotNull User advertiser, User chosenApplicant, @NotNull @Size(max = 64) String title, @NotNull String description, int payment, @NotNull @Size(max = 32) String category, boolean isPremium) {
        this.advertiser = advertiser;
        this.chosenApplicant = chosenApplicant;
        this.title = title;
        this.description = description;
        this.payment = payment;
        this.category = category;
        this.isPremium = isPremium;
    }

    public int getId() {
        return id;
    }

    public User getAdvertiser() {
        return advertiser;
    }

    public User getChosenApplicant() {
        return chosenApplicant;
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

    public String getCategory() {
        return category;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setAdvertiser(User advertiser) {
        this.advertiser = advertiser;
    }

    public void setChosenApplicant(User chosenApplicant) {
        this.chosenApplicant = chosenApplicant;
    }

    public void setTitle(String title) {
        this.title = title;
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
}