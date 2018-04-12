package com.japanredsun.Model;

public class Badge implements Comparable<Badge> {

    private long id;
    private String grade;
    private Integer point;
    private String imageURL;

    public Badge(long id, String grade, Integer point, String imageURL) {
        this.id = id;
        this.grade = grade;
        this.point = point;
        this.imageURL = imageURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        long comparedPoint = comparedBadge.getId();
        return (int) (this.id - comparedPoint);
    }
}
