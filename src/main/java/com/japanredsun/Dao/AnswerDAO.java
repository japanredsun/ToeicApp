package com.japanredsun.Dao;

import com.japanredsun.Model.Answer;

import java.util.List;

public interface AnswerDAO {

    List<Answer> getAnswersByQuestionId(long questionId);

    String insert(Answer answer);

    String update(Answer answer);

    String delete(long id);
}
