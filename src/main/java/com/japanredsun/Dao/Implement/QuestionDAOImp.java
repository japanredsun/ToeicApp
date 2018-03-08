package com.japanredsun.Dao.Implement;

import com.japanredsun.Dao.DataProvider;
import com.japanredsun.Dao.QuestionDAO;
import com.japanredsun.Dao.QuestionDetailsDAO;
import com.japanredsun.Model.Question;
import com.japanredsun.Model.QuestionDetails;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImp implements QuestionDAO {

    private DataProvider dataProvider = new DataProviderImp();

    private QuestionDetailsDAO questionDetailsDAO= new QuestionDetailsDAOImp();

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<Question>();
        String sql ="SELECT * From questions WHERE status = 1";
        try {
            dataProvider.initializeDB();
            ResultSet rs = dataProvider.executeReader(sql);
            while (rs.next()){
                long id = rs.getLong("id");
                String type = rs.getString("type");
                String paragraph = rs.getString("paragraph");
                Date createdDate = rs.getDate("created_date");
                int status = rs.getInt("status");
                List<QuestionDetails> questionDetailsList = questionDetailsDAO.getByQuestionId(id);

                Question question = new Question(id,type,paragraph,createdDate,status,questionDetailsList);
                questionList.add(question);
            }
            rs.close();
            dataProvider.closeDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }

    public List<Question> getQuestionsByType(String type) {
        return null;
    }

    public Question getQuestionById(long id) {
        return null;
    }

    public String insertQuestion(Question question) {
        return null;
    }

    public String updateQuestion(Question question) {
        return null;
    }

    public String deleteQuestion(long id) {
        return null;
    }
}
