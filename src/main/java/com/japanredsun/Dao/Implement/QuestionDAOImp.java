package com.japanredsun.Dao.Implement;

import com.google.gson.Gson;
import com.japanredsun.Dao.DataProvider;
import com.japanredsun.Dao.QuestionDAO;
import com.japanredsun.Dao.QuestionDetailsDAO;
import com.japanredsun.Model.Question;
import com.japanredsun.Model.QuestionDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImp implements QuestionDAO {

    private DataProvider dataProvider = new DataProviderImp();

    private QuestionDetailsDAO questionDetailsDAO= new QuestionDetailsDAOImp();

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<Question>();
        String sql ="SELECT * From questions WHERE status = 1";
        try {
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
                System.out.println("Added " +question.toString() +" to list");
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
        List<Question> questionList = new ArrayList<Question>();
        String sql = "SELECT * From questions WHERE type = ?";
        try {
            ResultSet rs = dataProvider.executeReader(sql);
            while (rs.next()){
                long id = rs.getLong("id");
                String paragraph = rs.getString("paragraph");
                Date createdDate = rs.getDate("created_date");
                int status = rs.getInt("status");
                List<QuestionDetails> questionDetailsList = questionDetailsDAO.getByQuestionId(id);

                Question question = new Question(id,type,paragraph,createdDate,status,questionDetailsList);
                questionList.add(question);
                System.out.println("Added " +question.toString() +" to list");
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

    public Question getQuestionById(long id) {
        return null;
    }

    public boolean insertQuestion(Question question) {
        String sql = "INSERT INTO questions (type,paragraph,status) VALUES (?,?,?)";
        String sql2 = "INSERT INTO question_detail (question_id,question,audio,picture,answers) VALUES (?,?,?,?,?)";
        try {
            dataProvider.initializeDB();
            PreparedStatement ps = dataProvider.getConn().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,question.getType());
            ps.setString(2,question.getParagraph());
            ps.setInt(3,question.getStatus());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                long id = rs.getInt(1);
                System.out.println("Added Question");
                List<QuestionDetails> list = question.getQuestions();
                for (QuestionDetails item :list
                        ) {
                    PreparedStatement ps2 = dataProvider.getConn().prepareStatement(sql2);
                    ps2.setLong(1, id);
                    ps2.setString(2,item.getQuestion());
                    ps2.setString(3,item.getAudioPath());
                    ps2.setString(4,item.getPicturePath());
                    ps2.setString(5,new Gson().toJson(item.getAnswers()));
                    ps2.executeUpdate();
                    ps2.close();
                    System.out.println("Added question details " + item.getQuestion());
                }
            }
            ps.close();
            dataProvider.closeDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean updateQuestion(Question question) {
        String sql = "UPDATE questions SET type = ?, paragraph = ?, status = ? WHERE id = ?";
        String sql2 = "UPDATE question_detail SET question = ?, audio = ?, picture = ?, answer = ? WHERE id = ?";
        try {
            dataProvider.initializeDB();
            PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
            ps.setString(1,question.getType());
            ps.setString(2,question.getParagraph());
            ps.setInt(3,question.getStatus());
            ps.setLong(4,question.getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("Updating question " + question.getId());

            for (QuestionDetails item :
                    question.getQuestions()) {
                PreparedStatement ps2 = dataProvider.getConn().prepareStatement(sql2);
                ps2.setString(1,item.getQuestion());
                ps2.setString(2, item.getAudioPath());
                ps2.setString(3, item.getPicturePath());
                ps2.setString(4,new Gson().toJson(item.getAnswers()));
                ps2.close();
                System.out.println("Updated question " + item.getQuestion());
            }
            dataProvider.closeDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean deleteQuestion(long id) {
        String sql = "DELETE From questions WHERE id = ?";
        String sql2 = "DELETE From question_detail WHERE question_id = ?";
        try {
            dataProvider.initializeDB();
            PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
            ps.setLong(1,id);
            ps.executeUpdate();
            ps.close();

            PreparedStatement ps2 = dataProvider.getConn().prepareStatement(sql2);
            ps2.setLong(1,id);
            ps2.executeUpdate();
            ps2.close();

            System.out.println("Deleted question " +id);

            dataProvider.closeDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
