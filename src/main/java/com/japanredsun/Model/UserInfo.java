package com.japanredsun.Model;

public class UserInfo {
    private String username;
    private Integer totalPoint;
    private String grade;

    public UserInfo() {
    }

    public UserInfo(String username, Integer totalPoint, String grade) {
        this.username = username;
        this.totalPoint = totalPoint;
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
