package com.japanredsun.Service;

import com.japanredsun.Model.Question;
import com.japanredsun.Model.Status;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface QuestionService{
    List<Question> getAllQuestions() throws SQLException, ClassNotFoundException;

    List<Question> getQuestionsByType(String type) throws SQLException, ClassNotFoundException;

    Question getQuestionById(long id) throws SQLException, ClassNotFoundException;

    void saveQuestion(Question question);

    void deleteQuestion(long id) throws SQLException, ClassNotFoundException;

    ObservableList<Status> getStatus();
}
