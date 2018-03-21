package com.japanredsun.Service.Implement;

import com.japanredsun.Dao.Implement.QuestionDAOImp;
import com.japanredsun.Dao.QuestionDAO;
import com.japanredsun.Model.Question;
import com.japanredsun.Model.Status;
import com.japanredsun.Service.QuestionService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionServiceImp implements QuestionService{

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
                    case 2: {
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

    @Override
    public ObservableList<Status> getStatusList() {
        Status active = new Status(1,"Active");
        Status inactive = new Status(0,"Inactive");
        return FXCollections.observableArrayList(active,inactive);
    }
}
