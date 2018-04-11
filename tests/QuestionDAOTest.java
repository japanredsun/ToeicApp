import com.japanredsun.Dao.Implement.QuestionDAOImp;
import com.japanredsun.Dao.QuestionDAO;
import com.japanredsun.Model.Question;
import org.junit.Assert;
import org.junit.Test;

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
    public void getActiveQuestions() {

    }

    @Test
    public void getQuestionsByType() {
    }

    @Test
    public void getQuestionsByTest() {
    }

    @Test
    public void getQuestionById() {
    }

    @Test
    public void insertQuestion() {
    }

    @Test
    public void updateQuestion() {
    }

    @Test
    public void deleteQuestion() {
    }
}