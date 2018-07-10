package com.codecool.web.model;

import javax.persistence.*;

@Entity
public class User extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String phone;

    @Column(name="user_name")
    private String userName;

    private String password;

    @Column(name="full_name")
    private String fullName;

    private String type;

    @Column(name="postal_code")
    private String postalCode;

    private String city;

    private String address;

    private int balance;

    private int reported;

    private boolean blocked;

    @Column(name="able_to_ad")
    private boolean ableToAd;

    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        type = "person";
        balance = 0;
        reported = 0;
        blocked = false;
        ableToAd = false;
    }

    public User(String email, String password, String userName, String type) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.type = type;
        balance = 0;
        reported = 0;
        blocked = false;
        ableToAd = false;
    }

    public User() {
    }

    public Integer getId() {
        return id;
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
