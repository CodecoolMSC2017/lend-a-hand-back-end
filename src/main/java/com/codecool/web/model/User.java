package com.codecool.web.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "advertiser")
    @JsonManagedReference(value = "user-ads")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Ad> ads;

    @ElementCollection
    @CollectionTable(
        name = "authorities",
        joinColumns = @JoinColumn(name = "username", referencedColumnName = "username")
    )
    @Column(name = "authority")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> authorities;


    @Column(name="has_paid")
    private Boolean hasPaid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rated")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference(value = "user-employee-rating")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EmployeeRating> employeeRatings;

    @Column(name = "employee_rating_score", columnDefinition = "DECIMAL(9,2)")
    private BigDecimal employeeRatingScore;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rated")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference(value = "user-employer-rating")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EmployerRating> employerRatings;

    @Column(name = "employer_rating_score", columnDefinition = "DECIMAL(9,2)")
    private BigDecimal employerRatingScore;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rater")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference(value = "user-rated-employee")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EmployeeRating> ratedEmployees;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rater")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference(value = "user-rated-employer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EmployerRating> ratedEmployers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference(value = "user-applications")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Application> applications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender")
    @JsonManagedReference(value = "user-sent-messages")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Message> sentMessages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiver")
    @JsonManagedReference(value = "user-received-messages")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Message> receivedMessages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "to")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference(value = "to-notification")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Notification> notifications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reporter")
    @JsonManagedReference(value = "sent-user-reports")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Report> reports;

    @Size(max = 32)
    private String email;

    @Size(max = 32)
    private String phone;

    @Column(name = "username")
    @Size(max = 60)
    private String userName;

    @Size(max = 60)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "picture_link")
    private String pictureLink;

    @Column(name = "full_name")
    private String fullName;

    private String type;

    @Column(name = "postal_code")
    @Size(max = 16)
    private String postalCode;

    private String city;

    private String address;

    private Integer balance;

    private Integer reported;

    private Boolean blocked;

    @Column(name = "able_to_ad")
    private Boolean ableToAd;

    private Boolean enabled;

    private Boolean verificated;

    @Column(name = "verification_code")
    private String verificationCode;

    public User() {
    }

    public User(@Size(max = 32) String email, String password) {
        this.email = email;
        this.password = password;
        this.hasPaid=false;
    }

    public User(@Size(max = 32) String email, @Size(max = 60) String userName, @Size(max = 60) String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        type = "person";
        balance = 0;
        reported = 0;
        blocked = false;
        ableToAd = false;
        enabled = true;
        this.hasPaid=false;
    }


    public User(@Size(max = 32) String email, @Size(max = 60) String userName, @Size(max = 60) String password, String type) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.type = type;
        balance = 0;
        reported = 0;
        blocked = false;
        ableToAd = false;
        enabled = true;
        this.hasPaid=false;
    }


    public User(List<Ad> ads, List<String> authorities, List<EmployeeRating> employeeRatings,
                BigDecimal employeeRatingScore, List<EmployerRating> employerRatings, BigDecimal employerRatingScore,
                List<EmployeeRating> ratedEmployees, List<EmployerRating> ratedEmployers, List<Application> applications,
                List<Message> sentMessages, List<Message> receivedMessages, List<Notification> notifications,
                List<Report> reports, @Size(max = 32) String email, @Size(max = 32) String phone,
                @Size(max = 60) String userName, @Size(max = 60) String password, String pictureLink,
                String fullName, String type, @Size(max = 16) String postalCode, String city, String address,
                Integer balance, Boolean blocked, Boolean ableToAd, Boolean enabled,
                Boolean verificated, String verificationCode) {
        this.hasPaid=false;
        this.ads = ads;
        this.authorities = authorities;
        this.employeeRatings = employeeRatings;
        this.employeeRatingScore = employeeRatingScore;
        this.employerRatings = employerRatings;
        this.employerRatingScore = employerRatingScore;
        this.ratedEmployees = ratedEmployees;
        this.ratedEmployers = ratedEmployers;
        this.applications = applications;
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;
        this.notifications = notifications;
        this.reports = reports;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.pictureLink = pictureLink;
        this.fullName = fullName;
        this.type = type;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
        this.balance = balance;
        this.reported = 0;
        this.blocked = blocked;
        this.ableToAd = ableToAd;
        this.enabled = enabled;
        this.verificated = verificated;
        this.verificationCode = verificationCode;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public int getId() {
        return id;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public List<EmployeeRating> getEmployeeRatings() {
        return employeeRatings;
    }

    public BigDecimal getEmployeeRatingScore() {
        return employeeRatingScore;
    }

    public List<EmployerRating> getEmployerRatings() {
        return employerRatings;
    }

    public void setEmployeeRatingScore(BigDecimal employeeRatingScore) {
        this.employeeRatingScore = employeeRatingScore;
    }

    public List<EmployeeRating> getRatedEmployees() {
        return ratedEmployees;
    }

    public List<EmployerRating> getRatedEmployers() {
        return ratedEmployers;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
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

    public BigDecimal getEmployerRatingScore() {
        return employerRatingScore;
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

    public Integer getBalance() {
        return balance;
    }

    public Integer getReported() {
        return reported;
    }

    public void setEmployerRatingScore(BigDecimal employerRatingScore) {
        this.employerRatingScore = employerRatingScore;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public Boolean getAbleToAd() {
        return ableToAd;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Boolean getVerificated() {
        return verificated;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public void setEmployeeRatings(List<EmployeeRating> employeeRatings) {
        this.employeeRatings = employeeRatings;
    }

    public void setVerificated(Boolean verificated) {
        this.verificated = verificated;
    }

    public void setEmployerRatings(List<EmployerRating> employerRatings) {
        this.employerRatings = employerRatings;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setRatedEmployees(List<EmployeeRating> ratedEmployees) {
        this.ratedEmployees = ratedEmployees;
    }

    public void setRatedEmployers(List<EmployerRating> ratedEmployers) {
        this.ratedEmployers = ratedEmployers;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
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

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
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

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public void setAbleToAd(Boolean ableToAd) {
        this.ableToAd = ableToAd;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setReported(Integer reported) {
        this.reported = reported;
    }

    public void increaseReported() {
        if (this.reported != null) {
            this.reported++;
        } else {
            this.reported = 1;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
