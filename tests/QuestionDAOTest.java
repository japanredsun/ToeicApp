import com.japanredsun.Dao.DataProvider;
import com.japanredsun.Dao.Implement.DataProviderImp;
import com.japanredsun.Dao.Implement.QuestionDAOImp;
import com.japanredsun.Dao.QuestionDAO;
import com.japanredsun.Model.Question;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionDAOTest {

    private QuestionDAO questionDAO = new QuestionDAOImp();

    @Test
    public void getAllQuestions() throws SQLException, ClassNotFoundException {
        List<Question> list = questionDAO.getAllQuestions();
        Assert.assertNotNull(list);
    }

    @Test
    public void getActiveQuestions() throws SQLException, ClassNotFoundException {
        List<Question> list = questionDAO.getActiveQuestions();
        Assert.assertEquals("1",list.get(0).getStatus());
    }

    @Test
    public void getQuestionsByType() throws SQLException, ClassNotFoundException {
        String type = "Reading - Part 6";
        List<Question> list = questionDAO.getQuestionsByType(type);
        Assert.assertEquals(type,list.get(0).getType());
    }

    @Test
    public void getQuestionsByTest() throws SQLException, ClassNotFoundException {
        String test ="Listening";
        List<Question> list = questionDAO.getQuestionsByTest(test);
        Question question = list.get(0);
        boolean isTrue = false;
        if(question.getType().contains("Listening")){
            isTrue = true;
        }
        Assert.assertEquals(true,isTrue);
    }

    @Test
    public void getQuestionById() throws SQLException, ClassNotFoundException {
        List<Question> list = questionDAO.getAllQuestions();
        long id = list.get(0).getId();
        Question question = questionDAO.getQuestionById(id);
        Assert.assertEquals(id,question.getId());
    }

    @Test
    public void insertQuestion() throws SQLException, ClassNotFoundException {
        List<Question> list = questionDAO.getAllQuestions();
        long id = list.get(0).getId();
        Question question = questionDAO.getQuestionById(id);
        Assert.assertEquals(true,questionDAO.insertQuestion(question));
    }

    @Test
    public void updateQuestion() throws SQLException, ClassNotFoundException {
        List<Question> list = questionDAO.getAllQuestions();
        long id = list.get(0).getId();
        Question question = questionDAO.getQuestionById(id);
        Assert.assertEquals(true,questionDAO.updateQuestion(question));
    }

    @Test
    public void deleteQuestion() throws SQLException, ClassNotFoundException {
        List<Question> list = questionDAO.getAllQuestions();
        long id = list.get(0).getId();
        Question question = questionDAO.getQuestionById(id);
        try{
            if(questionDAO.deleteQuestion(id))
            {
                Assert.assertEquals("2",questionDAO.getQuestionById(id).getStatus());
            }else {
                Assert.fail();
            }
        }finally {
            //revert
            question.setStatus("1");
            questionDAO.updateQuestion(question);
        }
    }
}