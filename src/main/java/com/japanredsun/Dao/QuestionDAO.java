package com.japanredsun.Dao;

import com.japanredsun.Model.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getAllQuestions();

    List<Question> getQuestionsByType(String type);

    Question getQuestionById(long id);

    boolean insertQuestion(Question question);

    boolean updateQuestion(Question question);

    boolean deleteQuestion(long id);
}
