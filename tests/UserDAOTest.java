import com.japanredsun.Dao.Implement.UserDAOImp;
import com.japanredsun.Dao.UserDAO;
import com.japanredsun.Model.User;
import com.japanredsun.Model.UserInfo;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {

    private UserDAO userDAO = new UserDAOImp();

    private String username;

    @Test
    public void getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> list = userDAO.getAllUsers();
        Assert.assertNotNull(list);
    }

    @Test
    public void getUserByUsername() throws SQLException, ClassNotFoundException {
        User user = userDAO.getUserByUsername("admin");
        Assert.assertEquals("admin",user.getUsername());
    }

    @Test
    public void getUserInfo() throws SQLException, ClassNotFoundException {
        UserInfo userInfo = userDAO.getUserInfo("admin");
        Assert.assertEquals("admin",userInfo.getUsername());
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        try{
            createUser();
            Assert.assertEquals(username,userDAO.getUserByUsername(username).getUsername());
        }finally {
            User user1 = userDAO.getUserByUsername(username);
            deleteUser(user1);
        }

    }

    public void createUser() throws SQLException, ClassNotFoundException {
        User user = new User("taile","12345","1","USER");
        userDAO.insert(user);
        username = user.getUsername();
    }

    public void deleteUser(User user) throws SQLException, ClassNotFoundException {
        userDAO.delete(user.getId());
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        createUser();
        User user = userDAO.getUserByUsername(username);
        try{
            if(user != null){
                userDAO.update(user);
            }else {
                Assert.fail("No user found");
            }
        }finally {
            deleteUser(user);
        }
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        createUser();
        User user = userDAO.getUserByUsername(username);
        if(user != null){
                userDAO.delete(user.getId());
                Assert.assertNull(userDAO.getUserByUsername(username));
        }else {
                Assert.fail("No user found");
            }

    }

    @Test
    public void updateUserInfo() throws SQLException, ClassNotFoundException {
        createUser();
        UserInfo userInfo = userDAO.getUserInfo(username);
        try{
            if(userInfo != null){
                userDAO.updateUserInfo(userInfo);
            }else {
                Assert.fail("No user found");
            }
        }finally {
            User user = userDAO.getUserByUsername(username);
            deleteUser(user);
        }
    }
}