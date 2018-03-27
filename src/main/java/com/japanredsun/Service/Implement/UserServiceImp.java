package com.japanredsun.Service.Implement;

import com.japanredsun.AppConfig;
import com.japanredsun.Dao.Implement.DataProviderImp;
import com.japanredsun.Dao.Implement.UserDAOImp;
import com.japanredsun.Dao.UserDAO;
import com.japanredsun.Model.Status;
import com.japanredsun.Model.User;
import com.japanredsun.Model.UserInfo;
import com.japanredsun.Service.Service;
import com.japanredsun.Service.UserService;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImp extends Service implements UserService {

    private UserDAO userDAO = new UserDAOImp();

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> list = userDAO.getAllUsers();
        List<User> newList = new ArrayList<>();
            for (User user :
                    list) {
                if(user.getIsActive() != null) {
                    int status = Integer.parseInt(user.getIsActive());
                    switch (status) {
                        case 1: {
                            user.setIsActive("Active");
                            break;
                        }
                        case 0: {
                            user.setIsActive("Inactive");
                            break;
                        }
                        default:
                            user.setIsActive("Active");
                    }
                    newList.add(user);
                }
            }
        return newList;
    }

    public User getUserByUsername(String username) throws SQLException, ClassNotFoundException {
        return userDAO.getUserByUsername(username);
    }

    public boolean authenticate(String username, String password) throws SQLException, ClassNotFoundException {
        User user = this.getUserByUsername(username);
        if(user != null){
            if(password.equals(user.getPassword())){
                AppConfig.setLoginUser(user);
                System.out.println("Login success");
                return true;
            }else{
                System.out.println("Wrong password");
                return false;
            }
        }else {
            System.out.println("User not found");
            return false;
        }
    }

    public UserInfo getUserInfo(String username) throws SQLException, ClassNotFoundException {
        return userDAO.getUserInfo(username);
    }

    @Override
    public ObservableList<Status> getStatus() {
        return super.getStatus();
    }

    @Override
    public void save(User user) throws SQLException, ClassNotFoundException {
        if(user.getId() > 0){
            userDAO.update(user);
            System.out.println("Update success");
        }else {
            userDAO.insert(user);
            System.out.println("Insert success");
        }
    }

    @Override
    public void detele(long id) throws SQLException, ClassNotFoundException {
        userDAO.delete(id);
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
