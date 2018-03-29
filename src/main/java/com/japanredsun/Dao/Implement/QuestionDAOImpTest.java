package com.japanredsun.Dao.Implement;

import com.japanredsun.Model.Question;
import com.japanredsun.Service.Implement.QuestionServiceImp;
import com.japanredsun.Service.QuestionService;
import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImpTest extends TestCase {

    private QuestionService service = new QuestionServiceImp();

    public void testGetQuestionsByTest() {
        List<Question> list = new ArrayList<>();
        try {
            list = service.getQuestionsByTest("reading");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean a = false;
        if(list.size() > 0){
            a = true;
            for (Question question :
                    list) {
                System.out.println(question.getType());
            }
        }
        assertEquals(a,true);
    }
}