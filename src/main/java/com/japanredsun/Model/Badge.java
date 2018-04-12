package com.japanredsun.Model;

public class Badge implements Comparable<Badge> {

    private String grade;
    private Integer point;
    private String imageURL;

    public Badge(String grade, Integer point, String imageURL) {
        this.grade = grade;
        this.point = point;
        this.imageURL = imageURL;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public int compareTo(Badge comparedBadge) {
        int comparedPoint = comparedBadge.getPoint();
        return this.point - comparedPoint;
    }
}
