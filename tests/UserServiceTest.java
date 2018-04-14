import com.japanredsun.Service.Implement.UserServiceImp;
import com.japanredsun.Service.UserService;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService service = new UserServiceImp();

    @Test
    public void authenticate() throws SQLException, ClassNotFoundException {
        // User: admin
        boolean isLogin = service.authenticate("admin","12345");
        Assert.assertEquals(true,isLogin);

        // User: admin + wrong password
        isLogin = service.authenticate("admin","55555");
        Assert.assertEquals(false,isLogin);

        // User not in database
        isLogin = service.authenticate("nouser","12345");
        Assert.assertEquals(false,isLogin);
    }
}