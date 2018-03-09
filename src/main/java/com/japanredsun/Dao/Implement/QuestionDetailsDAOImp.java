package com.japanredsun.Dao.Implement;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.japanredsun.Dao.DataProvider;
import com.japanredsun.Dao.QuestionDetailsDAO;
import com.japanredsun.Model.Answer;
import com.japanredsun.Model.QuestionDetails;

import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDetailsDAOImp implements QuestionDetailsDAO{

    private DataProvider dataProvider = new DataProviderImp();

    public List<QuestionDetails> getByQuestionId(long questionId) throws SQLException, ClassNotFoundException {
        List<QuestionDetails> questionDetailsList = new ArrayList<QuestionDetails>();
        String sql ="SELECT question, audio, picture, answers FROM question_detail WHERE question_id = ?";
            dataProvider.initializeDB();
            PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
            ps.setLong(1,questionId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String question = rs.getString("question");
                String audio = rs.getString("audio");
                String picture = rs.getString("picture");
                String answers = rs.getString("answers");
                // Convert Json Array to ArrayList
                Type listType = new TypeToken<ArrayList<Answer>>(){}.getType();
                List<Answer> answerList = new Gson().fromJson(answers, listType);

                QuestionDetails questionDetail = new QuestionDetails(question,audio,picture,answerList);
                questionDetailsList.add(questionDetail);
            }
            rs.close();
            ps.close();
            dataProvider.closeDB();
        return questionDetailsList;
    }

    public QuestionDetails getQuestionDetail(long questionId) {
        return null;
    }

}
