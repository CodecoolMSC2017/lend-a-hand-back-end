package com.codecool.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "user-reports")
    @JoinColumn(name = "reporter_id")
    @NotNull
    private User reporter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "user-reports")
    @JoinColumn(name = "reporter_id")
    @NotNull
    private User reportedUser;

    private Ad reportedAd;

    private String reportText;

}
