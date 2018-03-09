package com.japanredsun.Service.Implement;

import com.japanredsun.Dao.Implement.QuestionDAOImp;
import com.japanredsun.Dao.QuestionDAO;
import com.japanredsun.Model.Question;
import com.japanredsun.Service.QuestionService;

import java.sql.SQLException;
import java.util.List;

public class QuestionServiceImp implements QuestionService{

    private QuestionDAO questionDAO = new QuestionDAOImp();

    public List<Question> getAllQuestions() throws SQLException, ClassNotFoundException {
        return questionDAO.getAllQuestions();
    }

    public List<Question> getQuestionsByType(String type) throws SQLException, ClassNotFoundException {
        return questionDAO.getQuestionsByType(type);
    }

    public Question getQuestionById(long id) throws SQLException, ClassNotFoundException {
        return questionDAO.getQuestionById(id);
    }

    public void saveQuestion(Question question) throws SQLException, ClassNotFoundException {
        Question question1 = questionDAO.getQuestionById(question.getId());
            if(question1 != null){
                if(questionDAO.updateQuestion(question))
                    System.out.println("Update success");
            }else{
                if(questionDAO.insertQuestion(question))
                    System.out.println("Insert success");
            }
    }

    public void deleteQuestion(long id) throws SQLException, ClassNotFoundException {
        if(questionDAO.deleteQuestion(id)){
            System.out.printf("Delete %s success",id);
        }
    }
}
