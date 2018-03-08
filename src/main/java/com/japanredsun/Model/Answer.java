package com.japanredsun.Model;

public class Answer {
    private long id;
    private String answer;
    private boolean rightAnswer;
    private String explain;

    public Answer() {
    }

    public Answer(long id, String answer, boolean rightAnswer) {
        this.id = id;
        this.answer = answer;
        this.rightAnswer = rightAnswer;
    }

    public Answer(long id, String answer, boolean rightAnswer, String explain) {
        this.id = id;
        this.answer = answer;
        this.rightAnswer = rightAnswer;
        this.explain = explain;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }


}
