package com.japanredsun.Service.Implement;

import com.japanredsun.Dao.Implement.QuestionDAOImp;
import com.japanredsun.Dao.QuestionDAO;
import com.japanredsun.Model.Question;
import com.japanredsun.Service.QuestionService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionServiceImp extends ServiceImp implements QuestionService{

    private QuestionDAO questionDAO = new QuestionDAOImp();

    public List<Question> getAllQuestions() throws SQLException, ClassNotFoundException {
        List<Question> questionList = questionDAO.getAllQuestions();
        List<Question> newList = new ArrayList<Question>();
        for (Question one:questionList
                ) {
            if(one.getStatus() != null){
                int status = Integer.parseInt(one.getStatus());
                switch (status){
                    case 1: {
                        one.setStatus("Active");
                        break;
                    }
                    case 0: {
                        one.setStatus("Inactive");
                        break;
                    }
                    default:
                        one.setStatus("Not set");
                }
                newList.add(one);
            }
        }
        return newList;
    }

    public List<Question> getQuestionsByType(String type) throws SQLException, ClassNotFoundException {
        return questionDAO.getQuestionsByType(type);
    }

    @Override
    public List<Question> getQuestionsByTest(String testType) throws SQLException, ClassNotFoundException {
        return questionDAO.getQuestionsByTest(testType);
    }

    public Question getQuestionById(long id) throws SQLException, ClassNotFoundException {
        return questionDAO.getQuestionById(id);
    }

    public void saveQuestion(Question question){
        try {
            if(question.getId() > 0){
                if(questionDAO.updateQuestion(question))
                    System.out.println("Update success");
            }else
            {
                if(questionDAO.insertQuestion(question))
                    System.out.println("Insert success");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteQuestion(long id) throws SQLException, ClassNotFoundException {
        if(questionDAO.deleteQuestion(id)){
            System.out.printf("Delete %s success",id);
        }
    }
}
