package com.japanredsun.Model;

import java.sql.Date;

public class User {

    private long id;
    private String username;
    private String password;
    private String isActive;
    private String role;
    private Date createdDate;



    public User(String username, String password, String isActive, String role) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(long id, String username, String password, String role, Date createdDate, String isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Id: " + id +" username: " +username+" password: " +password+ " createdDate: " +createdDate+" role: " +role;
    }
}
