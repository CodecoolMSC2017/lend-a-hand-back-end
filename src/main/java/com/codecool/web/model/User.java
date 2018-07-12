package com.codecool.web.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "advertiser")
    private List<Ad> ads;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "rated")
    private List<EmployeeRating> employeeRatings;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "rated")
    private List<EmployerRating> employerRatings;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "rater")
    private List<EmployeeRating> ratedEmployees;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "rater")
    private List<EmployerRating> ratedEmployers;

    @NotNull
    @Size(max = 32)
    private String email;

    @Size(max = 32)
    private String phone;

    @Column(name = "user_name")
    @NotNull
    @Size(max = 32)
    private String userName;

    private String password;

    @Column(name = "full_name")
    private String fullName;

    @NotNull
    private String type;

    @Column(name = "postal_code")
    @Size(max = 16)
    private String postalCode;

    private String city;

    private String address;

    @NotNull
    private int balance;

    @NotNull
    private int reported;

    @NotNull
    private boolean blocked;

    @Column(name = "able_to_ad")
    @NotNull
    private boolean ableToAd;

    public User() {
    }

    public User(@NotNull @Size(max = 32) String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(@NotNull @Size(max = 32) String email, @NotNull @Size(max = 32) String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        type = "person";
        balance = 0;
        reported = 0;
        blocked = false;
        ableToAd = false;
    }


    public User(@NotNull @Size(max = 32) String email, @NotNull @Size(max = 32) String userName, String password, @NotNull String type) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.type = type;
        balance = 0;
        reported = 0;
        blocked = false;
        ableToAd = false;
    }

    public User(List<Ad> ads, List<EmployeeRating> employeeRatings, List<EmployerRating> employerRatings, List<EmployeeRating> ratedEmployees, List<EmployerRating> ratedEmployers, @NotNull @Size(max = 32) String email, @Size(max = 32) String phone, @NotNull @Size(max = 32) String userName, String password, String fullName, @NotNull String type, @Size(max = 16) String postalCode, String city, String address, @NotNull int balance, @NotNull int reported, @NotNull boolean blocked, @NotNull boolean ableToAd) {
        this.ads = ads;
        this.employeeRatings = employeeRatings;
        this.employerRatings = employerRatings;
        this.ratedEmployees = ratedEmployees;
        this.ratedEmployers = ratedEmployers;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.type = type;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
        this.balance = balance;
        this.reported = reported;
        this.blocked = blocked;
        this.ableToAd = ableToAd;
    }

    public Integer getId() {
        return id;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public List<EmployeeRating> getEmployeeRatings() {
        return employeeRatings;
    }

    public List<EmployerRating> getEmployerRatings() {
        return employerRatings;
    }

    public List<EmployeeRating> getRatedEmployees() {
        return ratedEmployees;
    }

    public List<EmployerRating> getRatedEmployers() {
        return ratedEmployers;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getType() {
        return type;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getBalance() {
        return balance;
    }

    public int getReported() {
        return reported;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isAbleToAd() {
        return ableToAd;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public void setEmployeeRatings(List<EmployeeRating> employeeRatings) {
        this.employeeRatings = employeeRatings;
    }

    public void setEmployerRatings(List<EmployerRating> employerRatings) {
        this.employerRatings = employerRatings;
    }

    public void setRatedEmployees(List<EmployeeRating> ratedEmployees) {
        this.ratedEmployees = ratedEmployees;
    }

    public void setRatedEmployers(List<EmployerRating> ratedEmployers) {
        this.ratedEmployers = ratedEmployers;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setReported(int reported) {
        this.reported = reported;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setAbleToAd(boolean ableToAd) {
        this.ableToAd = ableToAd;
    }
}
