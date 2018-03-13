package com.japanredsun.Model;

import java.util.List;

public class QuestionDetails {
    private long id;
    private String question;
    private String audioPath;
    private String picturePath;
    private List<Answer> answers;

    public QuestionDetails() {
    }

    public QuestionDetails(long id, String question, String audioPath, String picturePath, List<Answer> answers) {
        this.id = id;
        this.question = question;
        this.audioPath = audioPath;
        this.picturePath = picturePath;
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


}
