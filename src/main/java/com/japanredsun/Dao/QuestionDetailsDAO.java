package com.japanredsun.Dao;

import com.japanredsun.Model.QuestionDetails;

import java.sql.SQLException;
import java.util.List;

public interface QuestionDetailsDAO {

    List<QuestionDetails> getByQuestionId(long questionId) throws SQLException, ClassNotFoundException;

    QuestionDetails getQuestionDetail(long questionId);
}
