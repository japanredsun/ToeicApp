package com.japanredsun.Dao;

import com.japanredsun.Model.QuestionDetails;

import java.util.List;

public interface QuestionDetailsDAO {

    List<QuestionDetails> getByQuestionId(long questionId);

    QuestionDetails getQuestionDetail(long questionId);

    String insert(QuestionDetails questionDetails);

    String update(QuestionDetails questionDetails);

    String delete(long id);
}
