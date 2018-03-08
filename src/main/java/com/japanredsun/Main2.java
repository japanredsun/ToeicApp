package com.japanredsun;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.japanredsun.Dao.Implement.QuestionDAOImp;
import com.japanredsun.Dao.Implement.QuestionDetailsDAOImp;
import com.japanredsun.Dao.QuestionDAO;
import com.japanredsun.Dao.QuestionDetailsDAO;
import com.japanredsun.Model.Answer;
import com.japanredsun.Model.Question;
import com.japanredsun.Model.QuestionDetails;
import com.japanredsun.Model.User;
import com.japanredsun.Service.Implement.UserServiceImp;
import com.japanredsun.Service.UserService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args){
//        Answer answer1 = new Answer(1,"Answer 1",false,"it fail");
//        Answer answer2 = new Answer(2,"Answer 2",false,"it fail");
//        Answer answer3 = new Answer(3,"Answer 3",true,"it true");
//        Answer answer4 = new Answer(4,"Answer 4",false,"it fail");
//
//        List<Answer> answers = new ArrayList<Answer>();
//        answers.add(answer1);
//        answers.add(answer2);
//        answers.add(answer3);
//        answers.add(answer4);
//
//        // Store Json Array in DB
//        String json = new Gson().toJson(answers);
//        System.out.println(json);
//
//        //From Json Array in DB to Array List
        String jsonString = "[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]\n";
        Type listType = new TypeToken<ArrayList<Answer>>(){}.getType();
        ArrayList<Answer> answers1 = new Gson().fromJson(jsonString,listType);
//        System.out.println(answers1);

//        // test QDDAO

//        QuestionDetailsDAOImp questionDetailsDAOImp = new QuestionDetailsDAOImp();
//        List<QuestionDetails> questionDetailsList = questionDetailsDAOImp.getByQuestionId(1);
//        System.out.println(questionDetailsList);

//         test QuestionDAO
        QuestionDAO questionDAO = new QuestionDAOImp();
//        List<Question> questionList = questionDAO.getAllQuestions();
//        System.out.println(Arrays.toString(questionList.toArray()));
//        Question question = new Question();
//        question.setType("Vocabulary");
//
//
//        List<QuestionDetails> list = new ArrayList<QuestionDetails>();
//        list.add(new QuestionDetails("Question 1","","",answers1));
//        list.add(new QuestionDetails("Question 2","","",answers1));
//
//        question.setQuestions(list);
//
//        boolean done = questionDAO.insertQuestion(question);
//        System.out.println(done);


            // test Delete
            questionDAO.deleteQuestion(9);

    }
}
