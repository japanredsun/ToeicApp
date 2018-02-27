package com.japanredsun.Service.Implement;

import com.japanredsun.Dao.Implement.DataProviderImp;
import com.japanredsun.Dao.Implement.UserDAOImp;
import com.japanredsun.Dao.UserDAO;
import com.japanredsun.Model.User;
import com.japanredsun.Service.UserService;
import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImp implements UserService {

    private UserDAO userDAO = new UserDAOImp();

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public boolean authenticate(String username, String password) {
        User user = this.getUserByUsername(username);
        return user != null && password.equals(user.getPassword());
    }

//    public void test(){
//        DataProviderImp dataProviderImp = new DataProviderImp();
//        Label label = new Label();
//        try {
//            String sql = "SELECT username, password From users";
//            ResultSet rs = dataProviderImp.executeReader(sql);
//            //STEP 5: Extract data from result set
//            while(rs.next()){
//                //Retrieve by column name
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//
//                //Display values
//                System.out.print("User: " + username);
//                System.out.println(", Pass: " + password);
//
//
//                label.setText(username);
//            }
//            //STEP 6: Clean-up environment
//            rs.close();
//            dataProviderImp.closeDB();
//
//        }catch (SQLException ex){
//            ex.printStackTrace();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }finally{
//            //finally block used to close resources
//            dataProviderImp.finalyCheck();
//        }//end try
//    }

}
