package com.japanredsun.Dao;

import com.japanredsun.Model.Question;

import java.sql.SQLException;
import java.util.List;

public interface QuestionDAO {
    List<Question> getAllQuestions() throws SQLException, ClassNotFoundException;

    List<Question> getActiveQuestions() throws SQLException, ClassNotFoundException;

    List<Question> getQuestionsByType(String type) throws SQLException, ClassNotFoundException;

    List<Question> getQuestionsByTest(String testType) throws SQLException, ClassNotFoundException;

    Question getQuestionById(long id) throws SQLException, ClassNotFoundException;

    boolean insertQuestion(Question question) throws SQLException, ClassNotFoundException;

    boolean updateQuestion(Question question) throws SQLException, ClassNotFoundException;

    boolean deleteQuestion(long id) throws SQLException, ClassNotFoundException;
}
