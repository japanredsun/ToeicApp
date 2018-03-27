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
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDAOImp implements QuestionDAO {

    private static final Logger LOG = Logger.getLogger(QuestionDAOImp.class.getName());

    private DataProvider dataProvider = new DataProviderImp();

    private QuestionDetailsDAO questionDetailsDAO= new QuestionDetailsDAOImp();

    public List<Question> getAllQuestions() throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<Question>();
        String sql ="SELECT * From questions";
            ResultSet rs = dataProvider.executeReader(sql);
            while (rs.next()){
                long id = rs.getLong("id");
                String type = rs.getString("type");
                String paragraph = rs.getString("paragraph");
                Date createdDate = rs.getDate("created_date");
                String status = rs.getString("status");
                List<QuestionDetails> questionDetailsList = questionDetailsDAO.getByQuestionId(id);

                Question question = new Question(id,type,paragraph,createdDate,status,questionDetailsList);
                questionList.add(question);
                LOG.log(Level.INFO,"Select " + question.toString());
            }
            rs.close();
            dataProvider.closeDB();
        return questionList;
    }


    public List<Question> getActiveQuestions() throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<Question>();
        String sql ="SELECT * From questions WHERE active = 1";
        ResultSet rs = dataProvider.executeReader(sql);
        while (rs.next()){
            long id = rs.getLong("id");
            String type = rs.getString("type");
            String paragraph = rs.getString("paragraph");
            Date createdDate = rs.getDate("created_date");
            String status = rs.getString("status");
            List<QuestionDetails> questionDetailsList = questionDetailsDAO.getByQuestionId(id);

            Question question = new Question(id,type,paragraph,createdDate,status,questionDetailsList);
            questionList.add(question);
            LOG.log(Level.INFO,"Select " + question.toString());
        }
        rs.close();
        dataProvider.closeDB();
        return questionList;
    }

    public List<Question> getQuestionsByType(String type) throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<Question>();
        String sql = "SELECT * From questions WHERE type = ?";
            ResultSet rs = dataProvider.executeReader(sql);
            while (rs.next()) {
                long id = rs.getLong("id");
                String paragraph = rs.getString("paragraph");
                Date createdDate = rs.getDate("created_date");
                String status = rs.getString("status");
                List<QuestionDetails> questionDetailsList = questionDetailsDAO.getByQuestionId(id);

                Question question = new Question(id, type, paragraph, createdDate, status, questionDetailsList);
                questionList.add(question);
                LOG.log(Level.INFO,"Select " + question.toString());
            }
            rs.close();
            dataProvider.closeDB();
        return questionList;
    }

    public Question getQuestionById(long id) throws SQLException, ClassNotFoundException {
        Question question = new Question();
        String sql = "SELECT * From questions WHERE id = ?";
            ResultSet rs = dataProvider.executeReader(sql);
            if (rs.next()){
                String type = rs.getString("type");
                String paragraph = rs.getString("paragraph");
                Date createdDate = rs.getDate("created_date");
                String status = rs.getString("status");
                List<QuestionDetails> questionDetailsList = questionDetailsDAO.getByQuestionId(id);

                question.setId(id);
                question.setType(type);
                question.setParagraph(paragraph);
                question.setCreatedDate(createdDate);
                question.setStatus(status);
                question.setQuestions(questionDetailsList);

                LOG.log(Level.INFO,"Select " + question.toString());
            }
            rs.close();
            dataProvider.closeDB();
        return question;
    }

    public boolean insertQuestion(Question question) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO questions (type,paragraph,status) VALUES (?,?,?)";
        String sql2 = "INSERT INTO question_detail (question_id,question,audio,picture,answers) VALUES (?,?,?,?,?)";
            dataProvider.initializeDB();
            PreparedStatement ps = dataProvider.getConn().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,question.getType());
            ps.setString(2,question.getParagraph());
            ps.setString(3,question.getStatus());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            long id = rs.getInt(1);
            if(rs.next()){
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
                    LOG.log(Level.INFO,"Added " + item.getQuestion());
                }
            }
            ps.close();
            dataProvider.closeDB();
        return true;
    }

    public boolean updateQuestion(Question question) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE questions SET type = ?, paragraph = ?, status = ? WHERE id = ?";
        String sql2 = "UPDATE question_detail SET question = ?, audio = ?, picture = ?, answers = ? WHERE id = ?";
            dataProvider.initializeDB();
            PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
            ps.setString(1,question.getType());
            ps.setString(2,question.getParagraph());
            ps.setString(3,question.getStatus());
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
                ps2.setLong(5,item.getId());
                ps2.executeUpdate();
                ps2.close();
                LOG.log(Level.INFO,"Updated question " + item.getQuestion());
            }
            dataProvider.closeDB();
        return true;
    }

    public boolean deleteQuestion(long id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE From questions WHERE id = ?";
        String sql2 = "DELETE From question_detail WHERE question_id = ?";
            dataProvider.initializeDB();
            PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
            ps.setLong(1,id);
            ps.executeUpdate();
            ps.close();

            PreparedStatement ps2 = dataProvider.getConn().prepareStatement(sql2);
            ps2.setLong(1,id);
            ps2.executeUpdate();
            ps2.close();

            LOG.log(Level.INFO,"Deleted question " + id);
            dataProvider.closeDB();
        return true;
    }
}
