package com.japanredsun.Dao;

import com.japanredsun.Model.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getAllQuestions();

    List<Question> getQuestionsByType(String type);

    Question getQuestionById(long id);

    String insertQuestion(Question question);

    String updateQuestion(Question question);

    String deleteQuestion(long id);
}
