package com.japanredsun.Model;

import java.sql.Date;
import java.util.List;

public class Question {
    private long id = 0;
    private String type;
    private String paragraph;
    private Date createdDate;
    private String status;
    private List<QuestionDetails> questions;

    public Question() {
    }

    public Question(long id, String type, String paragraph, Date createdDate, String status, List<QuestionDetails> questions) {
        this.id = id;
        this.type = type;
        this.paragraph = paragraph;
        this.createdDate = createdDate;
        this.status = status;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<QuestionDetails> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDetails> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "id: " + id +" type: " +type + " created date: " +createdDate + " status: " + status + " Question_Detail_List_Size: " + questions.size();
    }
}
